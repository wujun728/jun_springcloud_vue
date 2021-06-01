package com.zebra.common.core.domain;

import tk.mybatis.mapper.version.NextVersion;
import tk.mybatis.mapper.version.VersionException;

/**
 * Title:乐观锁版本<br/>
 * Description:@Version(nextVersion = MyNextVersion.class)<br/>
 *
 * @author zebra
 * @Date 2020年3月2日
 *
 */
@SuppressWarnings("rawtypes")
public class MyNextVersion implements NextVersion {
	@Override
	public Object nextVersion(Object o) throws VersionException {
		if (o == null) {
			throw new VersionException("当前版本号为空!");
		}
		if (o instanceof Integer) {
			return (Integer) o + 1;
		} else if (o instanceof Long) {
			return (Long) o + 1L;
		} else {
			throw new VersionException("默认的 NextVersion 只支持 Integer, Long 类型的版本号，如果有需要请自行扩展!");
		}
	}
}
