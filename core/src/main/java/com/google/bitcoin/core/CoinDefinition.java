package com.google.bitcoin.core;

import java.math.BigInteger;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: HashEngineering
 * Date: 8/13/13
 * Time: 7:23 PM
 * To change this template use File | Settings | File Templates.
 */
public class CoinDefinition {
    
    
    public static final String coinName = "hamradiocoin";
    public static final String coinTicker = "HAM";
    public static final String coinURIScheme = "hamradiocoin";
    //public static final String cryptsyMarketId = "26"; // not yet on cryptsy
    public static final String cryptsyMarketCurrency = "BLEU_HAM";
    public static final String PATTERN_PRIVATE_KEY_START = "6";
    public static final String PATTERN_PRIVATE_KEY_START_COMPRESSED = "[Q]";
    public static final String PATTERN_PRIVATE_KEY_START_TESTNET = "9";
    public static final String PATTERN_PRIVATE_KEY_START_COMPRESSED_TESTNET = "c";
    
    public static String lowerCaseCoinName() { return coinName.toLowerCase(); }
    
    public enum CoinPrecision {
        Coins,
        Millicoins,
    }
    public static final CoinPrecision coinPrecision = CoinPrecision.Coins;
    
    
    public static final String BLOCKEXPLORER_BASE_URL_PROD = "http://blockexperts.com/";    //blockexperts.com fro HamRadioCoin
    public static final String BLOCKEXPLORER_ADDRESS_PATH = "ham/";             //blockr.io path
    public static final String BLOCKEXPLORER_TRANSACTION_PATH = "ham/tx/";              //blockr.io path
    public static final String BLOCKEXPLORER_BLOCK_PATH = "ham/hash/";                 //blockr.io path
    public static final String BLOCKEXPLORER_BASE_URL_TEST = BLOCKEXPLORER_BASE_URL_PROD;
    
    public static final String DONATION_ADDRESS = "DPdbL3n3Y3ypwVEvY3wABmpbjsd3AVqm5M";  //HashEngineering donation DGC address
    
    public static final String UNSPENT_API_URL = "http://blockexperts.com/ham/api";
    public enum UnspentAPIType {
        BitEasy,
        Blockr,
        Abe
    };
    public static final UnspentAPIType UnspentAPI = UnspentAPIType.Blockr;
    
    enum CoinHash {
        SHA256,
        scrypt,
    };
    public static final CoinHash coinPOWHash = CoinHash.SHA256;
    
    public static boolean checkpointFileSupport = true;
    public static int checkpointDaysBack = 21;
    //Original Values
    public static final int TARGET_TIMESPAN = (int)(1800);  // 1800 seconds per difficulty cycle, on average.
    public static final int TARGET_SPACING = (int)(180);  // 180 seconds per block.
    public static final int INTERVAL = TARGET_TIMESPAN / TARGET_SPACING;  //10 blocks
    
    public static final int getIntervalCheckpoints() {
        return INTERVAL * 100;    //1000
    }
    
    public static int spendableCoinbaseDepth = 100; //main.h: static const int COINBASE_MATURITY
    public static final BigInteger MAX_MONEY = BigInteger.valueOf(21000000).multiply(Utils.COIN);                 //main.h:  MAX_MONEY
    //public static final String MAX_MONEY_STRING = "200000000";     //main.h:  MAX_MONEY
    
    public static final BigInteger DEFAULT_MIN_TX_FEE = BigInteger.valueOf(10000);   // MIN_TX_FEE
    public static final BigInteger DUST_LIMIT = BigInteger.valueOf(0); //main.h CTransaction::GetMinFee        0.01 coins
    
    public static final int PROTOCOL_VERSION = 80002;          //version.h PROTOCOL_VERSION
    public static final int MIN_PROTOCOL_VERSION = 210;        //version.h MIN_PROTO_VERSION - eliminate 60001 which are on the wrong fork
    public static final int INIT_PROTO_VERSION = 209;            //version.h
    
    public static final int BLOCK_CURRENTVERSION = 1;   //CBlock::CURRENT_VERSION
    public static final int MAX_BLOCK_SIZE = 1 * 1000 * 1000;
    
    
    public static final boolean supportsBloomFiltering = false; //Requires PROTOCOL_VERSION 70000 in the client
    public static boolean supportsIrcDiscovery() {
        return PROTOCOL_VERSION <= 70000;
    }
    
    public static final int Port    = 15537;       //protocol.h GetDefaultPort(testnet=false)
    public static final int TestPort = 55534;     //protocol.h GetDefaultPort(testnet=true)
    
    //
    //  Production
    //
    public static final int AddressHeader = 0;             //base58.h CBitcoinAddress::PUBKEY_ADDRESS
    public static final int p2shHeader = 5;             //base58.h CBitcoinAddress::SCRIPT_ADDRESS
    public static final boolean allowBitcoinPrivateKey = false; //for backward compatibility with previous version of digitalcoin
    public static final long PacketMagic = 0x04050504;      //0x04, 0x05, 0x05, 0x04
    
    //Genesis Block Information from main.cpp: LoadBlockIndex
    static public long genesisBlockDifficultyTarget = (0x1e0fffffL);         //main.cpp: LoadBlockIndex
    static public long genesisBlockTime = 1404168899L;                       //main.cpp: LoadBlockIndex
    static public long genesisBlockNonce = (898704);                         //main.cpp: LoadBlockIndex
    static public String genesisHash = "00000fb62685078fccaf1ee757701c436145819f105b8d638f817782f9b817e2"; //main.cpp: hashGenesisBlock
    static public int genesisBlockValue = 0;                                                              //main.cpp: LoadBlockIndex
    //taken from the raw data of the block explorer
    static public String genesisTxInBytes = "04ffff001d01044c5348616d20526164696f204f70657261746f72732053657420557020666f7220416e6e75616c204669656c6420446179202d20362e32382e32303134202d20687474703a2f2f6269742e6c792f316d655a4c6858";   //"Ham Radio Operators Set Up for Annual Field Day - 6.28.2014 - http://bit.ly/1meZLhX";
    static public String genesisTxOutBytes = "e5ac";
    
    //net.cpp strDNSSeed
    static public String[] dnsSeeds = new String[] {
    "46.10.239.23",
    "209.188.18.188",
    "104.131.229.55",
    "108.61.10.90",
    "188.226.164.143",
    "91.121.165.120",
    "166.62.40.175",
    "192.99.13.126"
    };
    
    public static int minBroadcastConnections = 1;   //0 for default; we need more peers.
    
    //
    // TestNet - digitalcoin - not tested
    //
    public static final boolean supportsTestNet = false;
    public static final int testnetAddressHeader = 130;             //base58.h CBitcoinAddress::PUBKEY_ADDRESS_TEST
    public static final int testnetp2shHeader = 30;             //base58.h CBitcoinAddress::SCRIPT_ADDRESS_TEST
    public static final long testnetPacketMagic = 0x01fefe05;      //0xfc, 0xc1, 0xb7, 0xdc
    public static final String testnetGenesisHash = "5e039e1ca1dbf128973bf6cff98169e40a1b194c3b91463ab74956f413b2f9c8";
    static public long testnetGenesisBlockDifficultyTarget = (0x1e0ffff0L);         //main.cpp: LoadBlockIndex
    static public long testnetGenesisBlockTime = 1374901773L;                       //main.cpp: LoadBlockIndex
    static public long testnetGenesisBlockNonce = (1211565);                         //main.cpp: LoadBlockIndex
    
    
    
    
    
    //main.cpp GetBlockValue(height, fee)
    public static final BigInteger GetBlockReward(int height)
    {
        int COIN = 1;
        if(height == 1)
            return Utils.toNanoCoins(2100000, 0);
        BigInteger nSubsidy = Utils.toNanoCoins(50, 0);
        
        return nSubsidy.shiftRight(height / subsidyDecreaseBlockCount);
        
    }
    
    public static int subsidyDecreaseBlockCount = 50000;     //main.cpp GetBlockValue(height, fee)
    
    public static BigInteger proofOfWorkLimit = Utils.decodeCompactBits(0x1e0fffffL);  //main.cpp bnProofOfWorkLimit (~uint256(0) >> 20); // digitalcoin: starting difficulty is 1 / 2^12
    
    static public String[] testnetDnsSeeds = new String[] {
    "not supported"
    };
    //from main.h: CAlert::CheckSignature
    public static final String SATOSHI_KEY = "04016c44069c3152982413d3ba3bf262a3a4d3ddad859ba78e0d744f5c67c2205d2aa2122e6c62b6310dad2d1e2f7e39028455ff1dbb26511c60fc96c8b4560c43";
    public static final String TESTNET_SATOSHI_KEY = "";
    
    /** The string returned by getId() for the main, production network where people trade things. */
    public static final String ID_MAINNET = "org.hamcoin.production";
    /** The string returned by getId() for the testnet. */
    public static final String ID_TESTNET = "org.hamcoin.test";
    /** Unit test network. */
    public static final String ID_UNITTESTNET = "com.google.hamcoin.unittest";
    
    //checkpoints.cpp Checkpoints::mapCheckpoints
    public static void initCheckpoints(Map<Integer, Sha256Hash> checkpoints)
    {
        checkpoints.put( 0,     new Sha256Hash("00000fb62685078fccaf1ee757701c436145819f105b8d638f817782f9b817e2"));
        checkpoints.put( 1,     new Sha256Hash("00000edbc1a64b7da2459fb4036c894df5bd3f942393de830489a412cd05afe0"));
        checkpoints.put( 18879, new Sha256Hash("000000000001e5ddb097bd66ba8562d02b013b1343c506a4b68298db97e98aec"));
        checkpoints.put( 24307, new Sha256Hash("00000000000052932d94a2befa9909830ea34e524f270e7fb9a0f5974d7ad20a"));
        checkpoints.put( 28475, new Sha256Hash("000000000001d58a6e84328371e9d4e4de5b623285ca85647dbff938352df470"));
        checkpoints.put( 36067, new Sha256Hash("00000000000051d01893a2a5bb355340a8d6e274067172e4e9949b4f4fb5e96c"));
        checkpoints.put( 48580, new Sha256Hash("0000000000000af656a26d69a8095e1c3f0e719d756a05eccc5fa62032479448"));
        checkpoints.put( 49999, new Sha256Hash("000000000000179abc37df282a81e5997fc55fdb4fa9628e8d6e58dfa41ec9cc"));
    }
    
    //Unit Test Information
    public static final String UNITTEST_ADDRESS = "DPHYTSm3f96dHRY3VG1vZAFC1QrEPkEQnt";
    public static final String UNITTEST_ADDRESS_PRIVATE_KEY = "QU1rjHbrdJonVUgjT7Mncw7PEyPv3fMPvaGXp9EHDs1uzdJ98hUZ";
    
}