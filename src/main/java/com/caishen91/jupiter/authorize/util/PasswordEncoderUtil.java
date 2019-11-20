package com.caishen91.jupiter.authorize.util;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.caishen91.jupiter.config.Config;

public class PasswordEncoderUtil {

	private static BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
	
	/**
	 * 	加密
	 * @param rawPWD
	 * @return
	 */
    public static String encode(String rawPWD){
        String hashedPassword = passwordEncoder.encode(rawPWD);
        return hashedPassword;
    }
    
    /**
     * 	密码比对
     * @param rawPWD
     * @param encodePWD
     * @return
     */
    public static boolean matches(String rawPWD,String encodePWD){
        boolean result = passwordEncoder.matches(rawPWD, encodePWD);
        return result;
    }
    
    public static void main(String[] args) {
		System.out.println(encode(Config.DEFAULT_PASSWORD));
	}
}
