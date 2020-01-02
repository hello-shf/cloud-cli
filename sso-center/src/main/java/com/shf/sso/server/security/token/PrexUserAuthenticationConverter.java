package com.shf.sso.server.security.token;

import com.shf.sso.server.security.entity.PrexSecurityUser;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.oauth2.provider.token.DefaultUserAuthenticationConverter;
import org.springframework.util.StringUtils;

import java.util.Collection;
import java.util.Map;

/**
 * @Classname AdditionalUserAuthenticationConverter
 * @Description 解析jwt并将信息放入Authentication
 * @Author Created by Lihaodong (alias:小东啊) im.lihaodong@gmail.com
 * @Date 2019-09-10 10:54
 * @Version 1.0
 */
public class PrexUserAuthenticationConverter extends DefaultUserAuthenticationConverter {

    @Override
    public Authentication extractAuthentication(Map<String, ?> map) {
        if (map.containsKey(USERNAME)) {
            Collection<? extends GrantedAuthority> authorities = getAuthorities(map);
            String username = (String) map.get(USERNAME);
            Integer userId = (Integer) map.get("userId");
            PrexSecurityUser user = new PrexSecurityUser(userId, username, "", authorities);
            return new UsernamePasswordAuthenticationToken(user, "N/A", authorities);
        }
        return null;
    }

    /**
     * 获取权限信息
     * @param map
     * @return
     */
    private Collection<? extends GrantedAuthority> getAuthorities(Map<String, ?> map) {
        Object authorities = map.get(AUTHORITIES);
        if (authorities instanceof String) {
            return AuthorityUtils.commaSeparatedStringToAuthorityList((String) authorities);
        }
        if (authorities instanceof Collection) {
            return AuthorityUtils.commaSeparatedStringToAuthorityList(StringUtils
                    .collectionToCommaDelimitedString((Collection<?>) authorities));
        }
        throw new IllegalArgumentException("Authorities must be either a String or a Collection");
    }


}
