package jm.SpringBootCrudApp;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class InitialPassword {
    public static void main(String[] args) {
        bcryptEncoder();
    }
        static final Logger LOGGER = LoggerFactory.getLogger(InitialPassword.class);
        public static void bcryptEncoder(){
            BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder(12);
            String admin = bCryptPasswordEncoder.encode("");
            LOGGER.info("admin " + admin);
            String user = bCryptPasswordEncoder.encode("user");
            LOGGER.info("user " + user);
            String useradmin = bCryptPasswordEncoder.encode("");
            LOGGER.info("user " + useradmin);
        }

    }

