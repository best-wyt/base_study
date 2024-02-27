package com.wang.socket.encryption;

import org.bouncycastle.util.Strings;
import org.bouncycastle.util.encoders.Hex;

import java.security.SecureRandom;

public class SM4KeyUitl {

    /**
     * generate a secret key.
     * @return a random key or iv with hex code type.
     */
    public static String generateKeyOrIV() {
        byte[] key = new byte[8];
        new SecureRandom().nextBytes(key);
        return Strings.fromByteArray(Hex.encode(key));
    }

}
