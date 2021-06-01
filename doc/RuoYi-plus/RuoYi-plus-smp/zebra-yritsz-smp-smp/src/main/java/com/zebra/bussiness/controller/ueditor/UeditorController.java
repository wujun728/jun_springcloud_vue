package com.zebra.bussiness.controller.ueditor;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.zebra.common.config.ConfigServerApplication;
import com.zebra.common.core.controller.BaseController;
import com.zebra.common.utils.IpUtils;
import com.zebra.common.utils.ServletUtils;
import com.zebra.common.utils.StringUtils;
import com.zebra.common.utils.UidUtils;
import com.zebra.common.utils.file.FileUploadUtils;
import com.zebra.common.utils.spring.SpringUtils;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 活动点赞信息Controller
 *
 * @author zebra
 * @date 2020-04-23
 */
@Controller
@RequestMapping("/ajax/libs/ueditor/1.4.3")
@Slf4j
public class UeditorController extends BaseController {
    private final String METHOD_HEAD = "ueditor";
    private final String IMGE_PATH = "/ueditor/images/";
    private final String VIDEO_PATH = "/ueditor/videos/";
    private final String SCRAWL_PATH = "/ueditor/scrawl/";
    private final String FILE_PATH = "/ueditor/files/";

    @Value("${file.suffix.url}")
    private String fileSuffixUrl;

    /**
     * ueditor上传文件
     *
     * @param action
     * @param upfile
     * @return
     * @throws Exception
     */
    @ResponseBody
    @RequestMapping(value = "/ueditor/controller")
    public Object ueditor(HttpServletRequest request, @RequestParam(value = "action", required = true) String action, MultipartFile upfile) throws Exception {
        List<Object> param = new ArrayList<Object>() {{
            add(action);
            add(upfile);
        }};
        JSONObject json = new JSONObject();
        if (!action.equals(ActionEnum.CONFIG.action)) {
            if ("true".equals(SpringUtils.getBean(ConfigServerApplication.class).getDemoEnabled())) {
                log.info("[信息]演示环境不能上传：" + IpUtils.getIpAddr(request));
                json.put("state", "SUCCESS");
                json.put("url", "http://www.yritsz.com/ruoyi/演示环境.jpg");
                return json;
            }
        }
        Method method = this.getClass().getMethod(METHOD_HEAD + action, List.class, String.class);
        return method.invoke(this.getClass().newInstance(), param, fileSuffixUrl);
    }

    /**
     * 读取配置文件
     *
     * @param param
     * @return
     * @throws Exception
     */
    public JSONObject ueditorconfig(List<Object> param, String fileSuffixUrl) throws Exception {
        log.info("[信息]ueditor富文本器：" + ActionEnum.getActionEnumMsg(String.valueOf(param.get(0))));
        ClassPathResource classPathResource = new ClassPathResource("config.json");
        String jsonString = new BufferedReader(new InputStreamReader(classPathResource.getInputStream())).lines().parallel().collect(Collectors.joining(System.lineSeparator()));
        JSONObject json = JSON.parseObject(jsonString, JSONObject.class);
        return json;
    }

    /**
     * 上传图片
     *
     * @param param
     * @return
     * @throws Exception
     */
    public JSONObject ueditoruploadimage(List<Object> param, String fileSuffixUrl) throws Exception {
        log.info("[信息]ueditor富文本器：" + ActionEnum.getActionEnumMsg(String.valueOf(param.get(0))));
        JSONObject json = new JSONObject();
        json.put("state", "SUCCESS");
        json.put("url", ueditorcore(param, IMGE_PATH, false, fileSuffixUrl));
        return json;
    }

    /**
     * 上传视频
     *
     * @param param
     * @return
     * @throws Exception
     */
    public JSONObject ueditoruploadvideo(List<Object> param, String fileSuffixUrl) throws Exception {
        log.info("[信息]ueditor富文本器：" + ActionEnum.getActionEnumMsg(String.valueOf(param.get(0))));
        JSONObject json = new JSONObject();
        json.put("state", "SUCCESS");
        json.put("url", ueditorcore(param, VIDEO_PATH, false, fileSuffixUrl));
        return json;
    }

    /**
     * 上传附件
     *
     * @param param
     * @return
     * @throws Exception
     */
    public JSONObject ueditoruploadfile(List<Object> param, String fileSuffixUrl) throws Exception {
        log.info("[信息]ueditor富文本器：" + ActionEnum.getActionEnumMsg(String.valueOf(param.get(0))));
        JSONObject json = new JSONObject();
        json.put("state", "SUCCESS");
        json.put("url", ueditorcore(param, StringUtils.format("{}{}/", FILE_PATH, UidUtils.getUUID(true)), true, fileSuffixUrl));
        return json;
    }

    /**
     * 上传涂鸦
     *
     * @param param
     * @return
     * @throws Exception
     */
    public JSONObject ueditoruploadscrawl(List<Object> param, String fileSuffixUrl) throws Exception {
        log.info("[信息]ueditor富文本器：" + ActionEnum.getActionEnumMsg(String.valueOf(param.get(0))));
        String str = ServletUtils.getParameter("upfile");
        Base64 decoder = new Base64();
        byte[] b = decoder.decode(str);
        // 处理数据,把负的byte字节数据改为正的,作用未知
        for (int i = 0; i < b.length; ++i) {
            if (b[i] < 0) {
                b[i] += 256;
            }
        }
        String fileName = StringUtils.format("{}.{}", UidUtils.getUUID(true), "png");
        String url = FileUploadUtils.savefile(SpringUtils.getBean(ConfigServerApplication.class).getProfile() + SCRAWL_PATH, fileName, b);
        JSONObject json = new JSONObject();
        json.put("state", "SUCCESS");
        json.put("url", StringUtils.format("{}{}{}{}", fileSuffixUrl, "profile", SCRAWL_PATH, fileName));
        return json;
    }

    public String ueditorcore(List<Object> param, String path, boolean isFileName, String fileSuffixUrl) throws Exception {
        MultipartFile upfile = (MultipartFile) param.get(1);
        String fileName = null;
        if (isFileName) {
            fileName = upfile.getOriginalFilename();
        } else {
            String suffix = StringUtils.isEmpty(upfile.getOriginalFilename()) ? "png" : upfile.getOriginalFilename().substring(upfile.getOriginalFilename().lastIndexOf(".") + 1);
            fileName = StringUtils.format("{}.{}", UidUtils.getUUID(true), suffix);
        }
        String url = FileUploadUtils.savefile(SpringUtils.getBean(ConfigServerApplication.class).getProfile() + path, fileName, upfile.getBytes());
        return StringUtils.format("{}{}{}{}", fileSuffixUrl, "profile", path, fileName);
    }

    @Getter
    @AllArgsConstructor
    public enum ActionEnum {
        CONFIG("config", "读取配置文件"),
        UPLOAD_IMAGE("uploadimage", "上传图片文件"),
        UPLOAD_VIDEO("uploadvideo", "上传视频文件"),
        UPLOAD_SCRAWL("uploadscrawl", "上传涂鸦"),
        UPLOAD_FILE("uploadfile", "上传附件");
        private String action;
        private String msg;

        public static String getActionEnumMsg(String action) {
            for (ActionEnum actionEnum : ActionEnum.values()) {
                if (action.equals(actionEnum.getAction())) {
                    return actionEnum.getMsg();
                }
            }
            return null;
        }
    }


}
