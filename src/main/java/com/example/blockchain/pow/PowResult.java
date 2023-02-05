package com.example.blockchain.pow;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class PowResult {

    /**
     * 计数器
     */
    private long nonce;
    /**
     * hash值
     */
    private String hash;

}
