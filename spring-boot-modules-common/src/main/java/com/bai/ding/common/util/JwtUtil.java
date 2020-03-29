package com.bai.ding.common.util;

import com.bai.ding.common.constant.BackendEnumConstant;
import com.bai.ding.common.constant.BackendModulesConstant;
import com.bai.ding.common.exception.JwtException;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.LocalDateTime;
import java.util.Date;

/**
 * @author BaiDing
 * @date 2020/3/22 13:49
 */
public class JwtUtil {

    private static Logger logger = LoggerFactory.getLogger(JwtUtil.class);

    private static final String SUBJECT = BackendModulesConstant.getBaiDingJwtSubject();
    private static final String SECRETKEY = BackendModulesConstant.getBaiDingJwtSecretkey();
    private static final Long EXPIRE = BackendModulesConstant.getBaiDingJwtExpire();

    public static String generateJsonWenToken(long id, String name) {
        return Jwts.builder()
                .setSubject(SUBJECT)
                .claim("id", id)
                .claim("name", name)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + EXPIRE))
                .signWith(SignatureAlgorithm.HS256, SECRETKEY)
                .compact();
    }

    public static Claims checkJwt(String token) {
        try {
            final Claims claims = Jwts.parser().setSigningKey(SECRETKEY).
                    parseClaimsJws(token).getBody();
            return claims;
        } catch (ExpiredJwtException eje) {
            throw new JwtException(BackendEnumConstant.ResultCodeEnum.EXPIRED_TOKEN);
        } catch (Exception e) {
            throw new JwtException(BackendEnumConstant.ResultCodeEnum.INVALID_TOKEN);
        }
    }
}
