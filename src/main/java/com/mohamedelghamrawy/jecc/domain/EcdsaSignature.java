/**
 * EcdsaSignature class implements
 *
 * @author mhelghamrawy
 * @version 1.0
 * @since 10.04.22
 */

package com.mohamedelghamrawy.jecc.domain;

import lombok.*;

import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
public class EcdsaSignature {
    @NonNull
    private String message;
    private EccParameterSpec spec;
    private EcPoint Kpub;
    private BigInteger r;
    private BigInteger s;
}
