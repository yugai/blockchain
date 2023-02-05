package com.example.blockchain.block;

import com.example.blockchain.pow.PowResult;
import com.example.blockchain.pow.ProofOfWork;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.commons.codec.binary.Hex;

import java.time.Instant;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Block {

    /**
     * 区块hash值
     */
    private String hash;

    /**
     * 前一个区块的hash值
     */
    private String prevBlockHash;

    /**
     * 区块数据，未来会替换为交易
     */
    private String data;

    /**
     * 时间戳，单位秒
     */
    private long timeStamp;

    /**
     * 区块的高度
     */
    private long height;

    /**
     * 工作量证明计数器
     */
    private long nonce;




    /**
     * 创建新的区块
     *
     * @param previousHash
     * @param data
     * @return
     */
    public static Block newBlock(String previousHash, String data,long height) {
        Block block = new Block("", previousHash, data, Instant.now().getEpochSecond(),height,0);
        ProofOfWork pow = ProofOfWork.newProofOfWork(block);
        PowResult powResult = pow.run();
        block.setHash(powResult.getHash());
        block.setNonce(powResult.getNonce());
        return block;
    }

    private static final String ZERO_HASH = Hex.encodeHexString(new byte[32]);

    /**
     * 创建创世区块
     * @return
     */
    public static Block newGenesisBlock() {
        return Block.newBlock(ZERO_HASH, "Genesis Block",0);
    }


}
