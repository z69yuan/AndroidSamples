package com.beancurd.androidsamples

import android.util.Log
import okhttp3.Call
import okhttp3.Callback
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.Response
import okio.IOException
import org.dom4j.io.SAXReader
import org.junit.Test

import org.junit.Assert.*

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */

class EncryptItem(var first:String , var sencond:String ,var third:String) {
    override fun toString(): String {
        return "EncryptItem(first='$first', sencond='$sencond', third='$third')"
    }
}

const val KEY = "const KEY  = \""
const val IV = "const IV   = \""
const val DATA = "const DATA = \""

class ExampleUnitTest {
    @Test
    fun addition_isCorrect() {
//        assertEquals(4, 2 + 2)
        println("===========================")


        val x = """CPH2531
        CPH2577
        CPH2525
        CPH2521
        CPH2357
        RMX3830
        CPH2579
        RMX3636
        RMX3686
        RMX3771
        RMX3572
        RMX3741
        CPH2529
        RMX3563
        CPH1801
        CPH2437
        RMX3301
        RMX3231
        RMX3506
        CPH2519
        CPH2321
        CPH2499
        CPH1727
        CPH2551
        CPH2293
        CPH2607
        GM1910
        RMX1831
        CPH1869
        LE2100
        IN2010
        CPH1821
        CPH2307
        CPH2339
        CPH2557
        RMX3709
        RMX1851
        A0001
        CPH2599
        RMX3840
        GM1900
        RMX3396
        CPH2237
        CPH2591
        PHN110
        RMX3311
        RMX3842
        RMX3612
        DN2103
        DN2103
        CPH1803
        A101OP
        RMX2101
        RMX2103
        RMX3092
        CPH2421
        vivo 1820
        RMX3563
        RMX1811
        RMX2117
        V2026
        GN2200
        CPH2577
        RMX3686
        CPH2121
        RMX3231
        DN2100
        V2111
        RMX2193
        RMX1805
        DN2101
        PCDT10
        V2039
        CPH2137
        CPH2035
        PEMM00
        CPH2357
        V2043
        RMX3286
        CPH2305
        RMX2163
        vivo 1901
        vivo 2007
        V2027
        PDCM00
        CPH2013
        vivo 2019
        CPH2203
        V2120
        RMX1851
        vivo 1902
        CPH2307
        V2110
        PGCM10
        vivo 1938
        CPH1821
        PEGM10
        M2006C3MG
        PCDM10
        vivo 1807
        RMX3572
        vivo 1819
        CPH1901
        V2029
        PCKM80
        DE2118
        V2207
        PEGM00
        vivo 1935
        CPH1941
        RMX2176
        PCLM10
        RMX2001
        CPH1955
        CPH1801
        CPH2173
        M2003J15SC
        V2149
        CPH1723
        PCRT00
        CPH2275
        CPH2199
        V2204
        vivo 1724
        vivo 1915
        V2109
        M2006C3LG
        CPH1729
        CPH2249
        CPH1871
        Infinix X688B
                SM-A135F
        PEPM00
        CPH2247
        CPH2091
        PDNM00
        RMX3371
        PCAM10
        LE2100
        PGBM10
        M2101K7BNY
        vivo 1814
        Redmi Note 8
        V2116
        SM-A035F
        SM-A325F
        vivo 1907
        vivo 1920
        SM-G532G
        V2205
        CPH1853
        PEMM20
        V2038
        CPH2037
        vivo 1918
        CPH2221
        SM-A125F
        PCPM00
        vivo 1817
        M2004J19C
        PAFT00
        RMX1921
        2201117TY
                CPH2069
        PHJ110
        PAHM00
        SM-A037F
        PFCM00
        PECM30
        Redmi 6A
        CPH2273
        V2022
        PFVM10
        M2101K6G
        SM-A515F
        V2131
        Redmi 5A
        PEEM00
        PGGM10
        vivo 1919
        vivo 1727
        RMX2061
        RMX2200
        Redmi Note 7
        RMX3061
        V2025
        SM-G610F
        V2157
        CPH1877
        PCNM00
        RMX3370
        M2010J19CG
        V2030
        vivo 1816
        PDSM00
        SM-A207F
        SM-A127F
        SM-A107F
        CPH2519
        PCHM10
        Redmi Note 9 Pro
                SM-A115F
        Lito for arm64
        vivo 1802
        RMX2072
        vivo 1606
        PGJM10
        NE2213
        CPH2385
        V2108
        V2146
        SM-A025F
        V2130
        SM-A505F
        Infinix X657B
                V2201
        CPH1907
        CPH2293
        CPH2531
        SM-A042F
        vivo 1718
        RMX2161
        OPD2304
        vivo 1910
        M2007J20CG
        CPH1717
        RMX3561
        vivo 1929
        RMX1801
        V2217
        A102OP
        SM-A525F
        V2040
        CPH2579
        Redmi Note 5
        Redmi 4A
        CPH2223
        CPH2089
        vivo 1811
        SM-A205F
        CPH1917
        SM-A217F
        PEMT00
        OnePlus8Pro
        SM-A105G
        A103OP
        SM-A507FN
        SM-A235F
        vivo 1612
        CPH1609
        V2058
        CPH1701
        RMX1925
        vivo 1806
        PCET00
        Infinix X6812B
                CPH2437
        PEHM00
        SM-A528B
        Redmi Note 4
        NE2211
        SM-A145F
        21121119SG
                vivo 1808
        CPH2021
        220333QAG
                CPH2525
        M2010J19SG
        Redmi Note 8 Pro
                Infinix X657C
                Redmi 8
        V2118
        NE2215
        SM-A225F
        CPH1725
        Redmi 4X
        SM-A022F
        ASUS_X00TD
        SM-M127F
        PBDM00
        21061119AG
                SM-A315G
        RMX3830
        Redmi Note 5A
                M2102J20SG
        SM-A336E
        V2050
        PCHM00
        SM-A715F
        SM-A307GN
        Infinix X680B
                vivo 1716
        Redmi S2
                Redmi 5 Plus
        RMP2204
        M2101K7AG
        SM-A015F
        SM-M205G
        Mi A1
                SM-A032F
        SM-J730G
        RMX2121
        RMX3636
        SM-A750GN
        CPH1837
        SM-A305F
        GCE x86 phone
        2201117PG
                CPH2067
        CPH2499
        PFGM00
        vivo 1818
        SM-A045F
        SM-J415F
        CPH1825
        CPH1727
        RMX3235
        RMX3301
        M2103K19G
        PAFM00
        SM-A013G
        SM-J250F
        Infinix X6816
                SM-J610F
        Redmi 7
        RMX1831
        PEQM00
        vivo 1812
        NE2210
        Infinix X653C
                M2103K19PG
        PFZM10
        PENM00
        Redmi 6
        PEGT10
        Infinix X680
                vivo 1723
        CPH2065
        vivo 1804
        SM-N960F
        SM-A146P
        Infinix X650C
                220233L2G
        CPH2009
        SM-A536E
        PEXM00
        CPH2341
        RMX3771
        CPH2553
        CPH2201
        V2142
        220733SG
                Infinix X689B
                CPH2569
        V2202
        2201116TG
                2201116SG
                PGAM10
        V2238
        SM-A725F
        Redmi 5
        Infinix X6511E
                RMX2002
        Nexus 5X
        RMX1931
        Infinix X682B
                A001OP
        V2031
        SM-A226B
        Infinix X665B
                Redmi 8A Pro
        Infinix X689
                CPH2521
        SM-A736B
        RMX1807
        SM-A047F
        SM-G570Y
        SM-J330G
        SM-N950F
        SM-M115F
        vivo 1601
        SM-A520F
        vivo 1714
        SM-M215F
        PERM10
        PEDM00
        SM-A605G
        SM-N975F
        Infinix X682C
                22021211RG
                22071219CG
                SM-F711B
        Infinix X6511B
                Infinix X662
                Infinix X692
                V2231
        vivo 1719
        PCAT00
        SM-A705F
        GM1901
        SM-G935F
        Infinix X6512
                Infinix X656
                vivo 1609
        SM-G950F
        Redmi Note 6 Pro
                CPH1859
        SM-A346E
        SM-G965F
        RMX2086
        RMX3506
        CPH2025
        Infinix X695C
                SM-G955F
        ASUS_X01BDA
        RMX3741
        Redmi 3S
        SM-A600G
        Infinix X655C
                SM-A236E
        V2237
        V2214
        vivo Y66
                RMX1903
        SM-J400F
        M2012K11AG
        CPH1919
        Infinix X6823C
                SM-G990E
        vivo 1611
        SM-J600G
        SM-M105G
        Redmi 7A
        CPH2023
        SM-J530Y
        Infinix X669C
                CPH2551
        SM-G975F
        SM-J510FN
        vivo 1906
        ASUS_X00RD
        Infinix X6817
                21061110AG
                SM-J710F
        M2101K9AG
        Infinix X6515
                SM-A546E
        CPH2449
        SM-M515F
        SM-A530F
        SM-A245F
        POCOPHONE F1
                SM-A326B
        Infinix X6511
                itel L6502
                23021RAA2Y
                SM-F936B
        V2151
        Infinix X6827
                SM-T225
        V2247
        Infinix X693
                unknown
        Infinix X665E
                Infinix X663B
                vivo 1610
        SM-T295
        LYA-L29
        SM-M315F
        Mi A2 Lite
        6501
        SM-J810Y
        21081111RG
                SM-A730F
        Pixel 5
        SM-J701F
        SM-J260G
        Redmi 6 Pro
        SM-F721B
        SM-J700F
        Infinix X6816D
                22120RN86G
                SM-G985F
        SM-N985F
        SM-S908E
        Infinix X670
                OPPO A57
                M2007J20CI
        SM-A260G
        MI 8 Lite
        SM-C710F
        Infinix X688C
                M2007J3SG
        Redmi Note 3
        220333QPG
                SM-M307F
        SM-A805F
        SM-G780G
        Infinix X697
                SM-M325FV
        V2166
        SM-J500G
        CPH2557
        SM-A510F
        CPH1613
        6201
        dandelion
        2203129G
                23028RN4DG
                CPH1869
        SM-C900F
        vivo 1940
        Infinix X668C
                SM-M225FV
        Infinix X690B
                RMX2075
        OPD2203
        CPH2095
        CPH2417
        H8416
        MAR-LX2
        SM-M022F
        W-K560-ID
        MI MAX 2
        V2144
        SM-S918B
        Nokia 5.4
        22111317PG
                V2036A
        CPH2607
        SM-G9860
        SM-G988B
        Redmi Note 5A Prime
        vivo 1939
        INE-LX2
        SM-M526BR
        SM-N986B
        SM-G960F
        5505
        SM-M305M
        Infinix X676C
                PBAT00
        itel A571L
                A0001
        SM-N970F
        SM-A720F
        Redmi Note 4X
                SM-N980F
        VIVO Y17
                vivo Y19
                22101316G
                Infinix X652A
                SM-A500F
        AOSP on IA Emulator
                SM-A710F
        Infinix X652B
                V2252
        Infinix X627
                Mi A2
                SM-G998B
        A1601
        SMG991B
        22041219G
                MI MAX
                LG-M700
        Redmi 4
        Nokia 6.1 Plus
        SM-F926B
        SM-A310F
        SM-M336B
        V2105
        OXF-AN10
        Redmi Go
                SM-M236B
        Pixel 3 XL
        ASUS_X00ID
        Nokia 2.2
        Pixel 3a
        SM-G925F
        TECNO KE5
                2107113SG
                22071212AG
                ASUS_I001DE
        Infinix X6833B
                SO-02J
        Redmi 8A
        V2158
        SM-A920F
        SM-G930F
        vivo 1603
        Infinix X612B
                SM-G780F
        SM-P205
        SOV36
        M6A
        SM-S901E
        MEIZU_M5
        ASUS_Z00AD
        TECNO LE7
                V2302
        TECNO LG6n
                Redmi 3X
        ASUS_X01AD
        CPH2467
        SOV37
        vivo V15
                Pixel 6
        TA-1053
        CPH2411
        ASUS_I003DD
        SM-G981U1
        itel L6005
                SM-N935F
        SM-G960U1
        Nokia C3
                ASUS_X00LD
        SM-G390Y
        itel L6501
                vivo Y67
                TECNO LG7n
                SOV41
        YAL-L21
        M60
        Mi 10
        Pixel 3
        JSN-L22
        V2046
        Infinix X687
                Lenovo A7010a48
                SM-G991B
        6003
        LLD-L21
        CPH2617
        I2212
        CPH1945
        SM-S911B
        2207117BPG
                vivo Y17
                TECNO BD4i
                Infinix X698
                SM-G973F
        CLT-L29
        MI 8
        SM-N9208
        ASUS_I005D
        ASUS_X00QD
        Moto G (5S) Plus
                V2127
        M2007J3SY
        CPH1835
        LLD-AL20
        MI 9
        SM-G920F
        V2248
        MI 5X
        22081283G
                Pearl K2
                TECNO LF7n
                V2045
        ASUS_X008DA
        SH-01L
        ASUS_X00PD
        CPH2321
        F-01L
        i5G
        Pixel 2 XL
        TECNO KH6
                RNE-L22
        ASUS_X00AD
        itel A661L
                vivo Y55A
                Redmi Note 7 Pro
                RMX3471
        SOV39
        MI 6X
        EB2101
        SM-G885F
        Nokia C20
                RMX3750
        SM-N770F
        SM-N960N
        ASUS_Z01RD
        M6
        SM-J720F
        Infinix X689D
                Pixel 2
        2201122G
                DUA-L22
        Pixel 4a (5G)
        ZenFone Max Pro M1
                SM-M625F
        W-V730-ID
        i55C
        itel S661L
                SM-N976N
        Infinix X6810
                Infinix X5515F
                NX669J
        TA-1021
        VOG-L29
        L60 Pro
                Mi Note 3
        SM-M146B
        SC-02H
        Infinix X6831
                Lenovo A7000-a
        MI 5
        Pixel 4
        SM-M536B
        ZTE Blade A52
        Infinix X625D
                Nokia 5.1 Plus
        21091116C
                U70C
        CPH2309
        Moto E (4) Plus
                2209116AG
                SO-03L
        ASUS_X00HD
        V2044
        NX551J
        Infinix X678B
                MITO_A37_Z1
        SM-G965U
        MT2110
        CPH2523
        VIVO 1902
        SM-G770F
        Infinix X6811
                Mi MIX 2
        SM-G611F
        PCGM00
        Realme 5 Pro
        TA-1032
        iris88_lite
        SM-G996B
        Zenfone Max Pro M1
                L503F Plus
                SM-A105FN
        TECNO KD7
                ASUS_X017DA
        SM-P355
        ASUS_Z012DB
        8002
        Galaxy S22 Ultra 5G
        MAXTRON S8
                DUB-AL20
        BBC100-1
        801SO
                Infinix X663
                Realme 3 Pro
        SM-T835
        U40
        Infinix X6821
                G8341
        MHA-L29
        SM-G977N
        Mi 10 Pro
        SM-T505
        Infinix X672
                23053RN02A
                POCO F1
                ASUS_X00DDB
        TECNO LG8n
                XT1663
        21121210G
                GM1917
        701SO
                PFEM10
        SM-A307FN
        RMX3709
        TECNO BD4a
                LG-H870DS
        S50D
        OPPO A83
                i13 Pro Max
        DUB-LX2
        SH-C04
        MI MAX 3
        Nokia 5.3
        itel P682LP
                SCV39
        CET-AL00
        SM-S916B
        HTC M8Sw
                Infinix X650B
                SM-J710GN
        SO-04H
        CPH2529
        SM-J500FN
        D6653
        JKM-LX2
        V2249
        ASUS_X007D
        BKL-L09
        SO-01L
        Infinix X677
                Standard PC (i440FX + PIIX, 1996)
        SM-A7050
        SM-A910F
        CPH2451
        SH-S40P
        SM-A320Y
        SO-01J
        SOV35
        1013
        22101320G
                RMX3708
        SHV42
        Mi Note 10 Pro
                SM-J730GM
        LG-K430
        S22 Ultra
                SM-A205W
        TECNO KE5k
                Redmi Pro
                SKR-H0
        ASUS_Z00ED
        ASUS_Z00UD
        S23 Ultra
                mainline
        OPPO A83t
                MYA-L22
        P40pro
        SM-G925T
        SM-P585Y
        vivo Y93s
                Infinix X572-LTE
        V1934A
        Infinix X573
                Symbol R60
                6004
        Nokia G20
                SKW-H0
        MEIZU M6
                M2007J1SC
        SM-N910H
        ASUS_I005DA
        M7 Power
                itel A551L
                8001
        SM-G935T
        ADVANNASAPro
        Infinix X603
                Infinix X666B
                ASUS_X018D
        LUNA G9
                SM-T736B
        SOV40
        meizu C9
                CRO-L22
        SOV42
        6002
        PDHM00
        SM-X205
        SM-F900F
        F-03H
        SM-N960U
        SOV38
        Samsung Galaxy A70
        V2134
        LUNA G6E
                Pearl K3 2021
        SM-N910G
        SM-N920L
        U50C
        JAT-AL00
        vivo Y81S
                21051182G
                M53
        SCV38
        SM-M307FN
        8004
        itel P662L
                ASUS_Z017DB
        sdk_gphone64_arm64
        ASUS_A007
        vivo 1815
        5202
        SH-04L
        TECNO KF8
                CAM-L21
        E6683
        I2009
        Realme 5i
        Redmi K20 Pro
        SHV47
        Pixel XL
                SCV41
        5061
        LG-H990
        POCO F2 Pro
        vivo 1801
        IV2201
        M6T
        Nokia C31
                itel A662LM
                LG-K520
        Motorola One Vision
        CA060VR
        CPH2211
        S6
        SC-02K
        SM-F700F
        SM-G928I
        SM-G975U
        SO-03H
        TECNO PR651
                ASUS_I01WD
        LUNA V55A
                CPH1715
        L60
        Lenovo L78071
                OPPO R9s Plus
        V2183A
        ASUS_Z010D
        Mi 9T Pro
        MIX
        Lenovo K520
                OPPO A57t
                SM-F916B
        SM-G970F
        G8231
        LUNA V57
                M2102J20SI
        ONEPLUS A5000
                TECNO BD4
                HTV33
        IN2010
        SCV45
        SM-J730F
        MI PLAY
                SM-G610L
        V2034
        V2221
        TRT-LX2
        COR-L29
        PCAM00
        S41
        SM-G930V
        SM-N971N
        HUAWEI VNS-L31
        Infinix X6739
                MI 3W
        i55K
        Andromax B26D2H
                SM-G600S
        HRY-AL00a
        Infinix X622
                Mi Note 10
        23049PCD8G
                BL6000Pro
        SM-G930T
        ZT216_1
        BBB100-7
        LUNA G60X
                Lenovo L38011
                SM-P615
        LM-V510N
        SM-S906E
        CPH2161
        Lenovo TB-7304I
                SM-G955U
        SM-N9500
        Huawei Enjoy 9s
                LG-AS110
        LG-M250
        M653
        SM-G900H
        vivo X21i A
        itel S665L
                Lenovo L18081
                2014811
        CPH2005
        KYV40
        M5 Note
                itel L6503
                oppo6833
        I2216
        TECNO BF7
                2201123G
                A62
        IN2023
        SM-A800F
        SM-G892U
        vivo S1
                DUB-LX1
        Infinix X608
                SM-A6050
        G55 LITE
                KYV41
        ASUS_AI2202
        MI 6
        Nexus 4
        SH-C03
        SM-T825Y
        vivo 1713
        LG-H930
        SM-F707B
        vivo V11 Pro
        Lenovo P1a42
                SM-A2070
        SM-G925I
        Virtual Machine
                CELL
        CPH1979
        MRD-LX1F
        SHV45
        SM-G960U
        SM-J415FN
        TECNO KE5j
                ALDO
        EVA-L19
        Mi 9 SE
        SHV38
        SM-G920I
        ALP-L29
        5059
        AE9950
        SM-G5700
        SM-G975N
        SM-J510GN
        T8
        PHV110
        SM-J320G
        Smart Phone
                802SO
                CPHD2E2
        CPH1607
        Infinix X6815B
                NX659J
        OPPO F5
                SM-A908B
        JKM-LX1
        OPPO A73
                Pearl K2 2020
        TECNO LD7
                Lenovo L38041
                MIX 3
        SM-G900I
        SM-N986U
        CPH1920
        M5
        S45B
        SM-C9000
        ASUS_AI2201_D
        F5122
        MI NOTE LTE
        Pixel 4a
        LUNA V6
                SM-N920S
        SOV32
        ALP-AL00
        CPH2339
        Lenovo A6600d40
                XT1706
        BLA-A09
        LUNA V55
                Lenny4 Plus
                Moto G (7)
        SM-G980F
        moto g(30)
        CPH2377
        HM-G552-FL
        LM-Q510N
        VIVO S1
                601SO
                Mi 9T
        Nokia C1
                Redmi Y1 Lite
        SM-A136B
        5502
        BV4900Pro
        RMP2105
        SM-G973U
        WP001
        vivo Y97
                6001
        SM-T585
        SO-05K
        H8116
        LG-K220
        Moto C Plus
        Nokia G10
                Redmi 9A
        9027Q
                Infinix X6815D
                Nexus 5
        ATU-L31
        HM-N700-FL
        SM-T385
        H8216
        PCT-L29
        SHV37
        SM-J5108
        SM-N910S
        SM-T719Y
        SM-X200
        Mi 9X
        SM-J400M
        TECNO CI8n
                MAR-AL00
        MAXTRON Genio
                Star
        CPH1831
        Nokia 1
        SM-G532F
        SO-03K
        ASUS_Z01HD
        EML-L29
        Pixel 4 XL
        SO-03J
        vivo V9
                1010
        8003
        CPH2207
        Infinix S2 Pro
        Redmi Note 5 Pro
                SM-A105F
        SM-G975U1
        SM-G9880
        SM-T555
        SM-T715Y
        VS987
        iPhone 13 Pro Max
        iPlay_20
        itel S663LC
                GM1910
        Infinix X510
                LM-V500N
        S45
        V1923A
        2201116PG
                F8132
        SM-A013M
        SM-G920K
        SM-J410F
        i12 Pro Max
        vivo Y71A
                AUM-AL20
        LM-F100N
        M50 STAR
                SM-A6060
        SM-N920C
        SM-N950N
        TECNO KG5k
                702SO
                M2102K1G
        M760
        Nexus 6P
        Pocophone F1
                SM-F946B
        V1813A
        ASUS_Z01BDB
        Realme 5
        SM-C7000
        V1901A
        13 Pro Max
        GT2 Pro
                SHT-AL09
        SO-02H
        TECNO KI5q
                U6
        Andromax A26C4H
                LM-Q725K
        MAXTRON S10
                MITO_A37_Z1plus
        Rino8 Pro
                SM-G615F
        U70B
        LUNA G58
                MI 4S
        Nokia C21 Plus
        SAMSUNG-SM-G935A
        SM-G950N
        INE-LX1
        Infinix_X521_LTE
        M33
        SM-J610G
        SM-N950S
        SM-N950U1
        vivo V11i
                CHP1723
        LDN-LX2
        STK-L22
        CPH1805
        CPH1912
        Coolpad E502
                SM-G6100
        i14 Pro Max
        iris60
        vivo Y83
                BLL-L22
        F-05J
        L50
        Mi MIX 3
        ONEPLUS A3010
                S12
        SM-T590
        SO-01K
        CPH2285
        D5803
        JAD-LX9
        LE2121
        NEM-AL10
        OPPO A39
                MI 8 SE
        Redmi Note 5A Lite
        SO-02K
        CPH1605
        CPH2048
        Mi-4c
                SHV39
        SO-04G
        vivo Y93
                E5663
        POCO X3
                SH-04H
        SM-G887N
        SM-G973N
        SM-J400G
        LE2123
        M2010J19SY
        SM-G9287C
        SM-N910U
        SM-P619
        DRA-LX2
        E6653
        G3116
        HD1913
        P7 Max
                V1809A
        V2012A
        5041
        ANA-NX9
        ASUS_X009DA
        F8331
        HD1900
        Infinix X604
                OPG02
        POLYTRON_P552
        SCV42
        4412c50afbfcebd4
                H8266
        HTC U11
                MI A2
                Neffos_C9A
        Pro_Max13
        Redfin 64-bit only
        SM-A705FN
        SM-G935FD
        TECNO LE6
                U50A_PLUS
        X7
        moto g 5G
                BAH3-W59
        SM-A326BR
        SM-C5010
        SM-G900FD
        5062
        ASUS_X008
        Galaxy S20
                M2011K2G
        Meizu M6s
                POLYTRON_P520
        SM-G5510
        ADVAN 1011
        BLA-L29
        LUNA G5
                M55
        NLS-MT65
        SHARK KLE-H0
        BV9100
        M5s
        MI 8 Pro
        Mi 9 Lite
        PBAM00
        SM-A137F
        SM-F731B
        SM-G9208
        SM-N960U1
        F8131
        G011A
        NX709J
        RMX2027
        SM-G935K
        ST7701
        iCherry C251
                14 Pro Max
        5060
        5501
        ASUS_AI2201_C
        CPH1903
        K350t
        Moto E (4)
        PICOpad-7H
                RMX2190
        V1818CA
        W_K600
        HEY-W09
        KYV45
        M850
        Nokia 2
        Nokia 4.2
        OPD2102A
        Redmi 10
        SM-610F
        SM-A526B
        SM-G9750
        SM-J510UN
        23043RP34G
                G8142
        CPH1851
        LG-M400
        PGX110
        SM-F936N
        SM-J260F
        SM-N915F
        Standard PC (Q35 + ICH9, 2009)
        U2
        iris702
        CPH2399
        SM-A4260
        SM-A505N
        SM-A705MN
        SM-G935P
        SM-J510F
        ANE-TL00
        Coolpad E503
                M2012K11AC
        PEUM00
        PGEM10
        PM75
        SM-A205FN
        SM-X700
        2109119DG
                AUTOID Q9
                CPH1881
        GOME_C7_Note_Plus
        HUAWEI MT7-TL10
        Lenovo L38012
                Mi 8
        OPPO R11st
                PBEM00
        R50A
        SM-J530F
        SM-N950U
        SM-N975U1
        HARRY
        I2213
        Kona for arm64
        L52 Pro
                LDN-L21
        Lenovo L38083
                PGW110
        POLYTRON_4G503
        d-01J
        iris870
        vivo X9
                5063
        ELE-L29
        Lenovo P2a42
                RMX1945
        Redmi 4 Prime
        SHV44
        SM-N916K
        Z999
        i55D
        A5010
        Lenovo Z90a40
                M5c
        Realme C2
                Redmi Note 10
        S1
        S55B
        SM-A305N
        SX
        AOSP on IA x86_64 Emulator
        CPH1809
        Infinix X626B LTE
        Lenovo K320t
                Moto C
                V55C
        G3416
        Infinix HOT 4 Pro
                Nokia 6.2
        SM-N976B
        SO-01M
        TAS-AN00
        VIVO Y3s
                i7
        metaphone
        ASUS_X00DD
        CPH1821EX
        Nokia 3.1 Plus
        SM-T975
        V1813T
        HUAWEI CAN-L01
        PFFM10
        RMX1827
        SM-T705
        TECNO KI5m
                V1824BA
        ASUS_X00TDA
        Axioo_AX4
        CA081VR
        LG-US998
        LIO-L29
        SM-G991U
        SM-G996N
        vivo 1933
        MAR-LX1M
        A201OP
        ASUS_Z01MD
        LG-H830
        LNA-AL00
        PDKM00
        RMX1825
        S22 Ultra 5G
                SM-N910L
        ossi
        sdk_gphone_x86_64_arm64
        AMN-LX2
        PGT-N19
        SM-A2360
        V2206
        ZTE BLADE A520
        moto g82 5G
                GT-I8190N
        IM-A850L
        SM-G530H
        SM-G981N
        SM-N916L
        SM-T725
        V2156FA
        V2285A
        CPH1943
        E6883
        HUAWEI P2-6011
        Infinix X6820
                M1901F71
        SM-A315F
        V1818CT
        vivo 1805
        N5206
        NAM-LX9
        SM-G9910
        Lenovo K50a40
                STK-L21
        LG-H933
        LM-G710N
        MI 2A
        SM-J200F
        2106118C
                BvsMBH
        HUAWEI LUA-L03
        PHB110
        V2284A"""

        reqeust("BvsMBH")
        reqeust("HUAWEI LUA-L03")
        reqeust("PHB110")
        reqeust("V2284A")
        reqeust("2106118C")
        reqeust("SM-J200F")

//        val KEY  = "QBRVIxUmy9iq9MNE8sggPA=="
//        val IV   = "KpJwdK+TCibDF5QUrdo2zw=="
//        val DATA = "rAM2vSLBsLn6ZPZ1RKfWEBNf9mAitlHrPx+IPZTNTSJFUvvQ624ZWrMWh/V8mAXeO/VyIeV5IL/5VVlJG5y63tUMVkyCKe5Q1/0Yr5071zhUepRc2qBuwsO7CxpYEdT5TOSCgTTdM/zHIczqlv5mnyfwtgeIof21BXcu3CwpYgLgOoY/APDKZMbdbQkqn3bZXbsqnNSt8AHr68H57Q32UKujZ8+cixlixx0wlrhasDwd+3I6/3zxUG14gpMNXV4/3Ag4/3a3LLWhNcyXpFWD0Y67jp2BsNOSeTTSu2OnaHjXruUNe7wzByJJ4JvEROCnZHwV/emZrQegiqq/q7DPDQSOoIhg9LF8b7VXW63cArTqqi6tq2VAxA8tmzrZT+ke/dISI30uMKB9gAdS8swa4KN0/OM57rFoNacvPHKVyQan8jTgoEyYcko+NNPqlc6c0R5Kvlo4XTNrBCT9SyTYdpo1XB37fv6ESLwjGJhtP12ZakxTvcm1Y3fbj1uvPm83sqGilyZ2WMObBlcfjjexOPW8VsZq/JAGXWVZhI2N3etvIn28EljkXvp+p6oQJE7vXqbYdMNRvnJJ18/rsPg+D4SIL7mWpEYdamFhHrr/CpDcqIkxNgV/jNYGgtc2t6cd82veIYmj4krvHA+Wg1xo8WUJ12h2Pphynq0wksOKO4Bp2MTTEGAMQ7pgiMusKh3xyr8iHIY+os5MSfjhKl7tCqW+jP44RhdMCiHJ8qmPDQ1YZ6yY9o4TzA39ItRM9IHq+f9XlB0wGUeVpKbG1JkRX51NXek2Htmf/Vmv1Jf1b+4WKFf3884dbIivVGX2pK2eEH8bejjrIFFCw0cjgorD8alZ9VLH1Xw+geu1EhmKrW15u34vi2D2KxFh1KgfbaYB/ELMqw3+jqlWr0UBQknMxU+Y2HZrr4v+/OJBQzOeY6r04xoHv8SbmQPfaneOaHxzAovCfIs9A5OUw5T+lNXvJxfck5jKHcsfCH44MDA+nkc5v8tqkdbPSFdVg9WUvYmw4PUeeBqPIMahiOmN/7/W3np9/DZzmHnraElAXq+EvQrLgSLtu2TeyZA7JkMHvRqpoZOnWjAWyHZe5fXS3QBUO3LZmgE1pDu3322C7nBbDzM4agAZvkCXmueBv+0q2z7Xvr22him5h9C3dFu64J/pDVAdKehHaL6vFJGIjeH7M4efdUvpiZwZjoJwBfioIDr+m4jf7ztvrm2ZsMeelpx3LMFVL3JC1zKOYvqMbkz3d4a8Ka1Tg5liuoOt1KCcv4EjumlbX2ejjY44CohFt0GtX2NmJFPmsJp9G03K+wTYU5G32GOppwyHddmBoFJbRQ0wD7p5+vPf0s+xTHpAKI6X3BKJi83oFY3ayCTtK7vAmc2aupNqUOsJboa+dOee9jX2tb6mikNOQoHX43qDzEmb5g==";
//        val r = AESDecrypt.decrypt(KEY,IV,DATA)
//        println("r = $r")


        val KEY  = "4Aqx94dAz3lFP3IqjXi1iA==";
        val IV   = "tDftleAyUSoFIY24bLwJ/Q==";
        val DATA = "yNqOsy6eOt1Dwn/5cfvpDVL9+xhM/NhQu2xQmR2n2Fm2PpDRWgQzvumPG3REWCjE1kzhueSUEbFmDhmrNP73IrFCqPpnlmMSE3oyKgGILY0g435aPcfsNdnKqgzNBiK6xzk5ckoDpl+prbQgDLEY3yEfYaDdUGq3oqrJLNP7N0qECX1XMF/DWadEilhPbfd4OS904f15N4jBR88y1SBNR6jdqQ23PkAu5+yrs8x/6LvWwudDdXZBH3MakqChvgBxQxpepA6/COqjPbv58dO3zMdX1BcQ4O95LfxzmkrjsBhrxIEPFPRafh0fOVC5a/xzXArBAoFe6+J6yHZVoKL+w4LLHdr6h4SpTyRiPcMJ13hfjwU/9glIZfyU9556O7bf8a1X0Afz8ZUXVQL6Ff88uamRco9F1ljcn0ZE/igxo17rNkpPXY+ez0hv8445lk4d6cJn0tWUQ0GKlUqtYPPbB+m0phIhrrgi/hV57YWfHC9Vi0vQyeA6Hrb02H/Ev7RF1XspzSoIeQ9ef3xkI29Z4L3kcygySaFc8llWCITIbvfSIIaBijsd6VNwgohyHHi9qU2Y5Wqli9u6du5HS/QMCQtasS0Rt1F3jJWrKoJCnxM0QFw77ur/YQfLgo1/6aGDvS3nr2huEi+N22QTztX4TQ5TBCJe3r0bYdY+UjTScwgC3RglwXp5i7BeeTmzjICKKIXqKzlUiTGiBnLlaS1zUGCOtlqxKCyAWWcF94SPbspoTpTchMaRA4ooBMidyABdO+E02INitc+j6D1mc+KTEflLWcplB4rfCKLCiWrctzdCqrdgrhtzW2D06UBZwdh/eu9WSOwrrz9yg3aAOp39qWrHHKSeLEAdrItUs/J4zBhKUQG6FYE/qBRD8Gwy1chKVnNQysWn9LoUVQ/jnOsGuGoS9dsHRvhLULUhhG5XatnJMszIhIAzjDNQv4AQY0Ozmdt2SzkqRpR5Z+k41OkfcNViSeeNVzuSVSLoBUbGdjL2KNU4PPJf2Btjsw0mokoVTJ9h6B+J0kFZcO/z02MVSrPLUeunW/Ft8UJCElXwixkNMSLkwhkelsfRmYUUykH2mYo4AKp5TRLMVoHOoc7YV5cEswPv1HL8pV+rNP3HAeb6UvYMPfeudeDBVcskTIwZxi6zGJ4j37lB2B06RWdRmVzWhrHC624UWyTPAtiepJGEhqWBUkTVKmlcyqdcfsP154z9ZWCYnUkPRUs7vuyUGg==";
        val r = AESDecrypt.decrypt(KEY,IV,DATA)
        println("r = $r")
    }

    fun reqeust(key:String) {
        val request = Request.Builder()
            .url("https://www.gsmarena.com/res.php3?sSearch=${key}")
            .build()
        val call = OkHttpClient().newCall(request)
        val res = call.execute()
        if (res.code == 200) {
            // 打印请求信息
//            val content = res.body?.byteStream()?.bufferedReader()?.readText()
//            println(content)

//            <script>
//                    const KEY  = "olLloUHr96XKUaN6HZw1Eg==";
//            const IV   = "bVOHD40f/r42B708XWskKA==";
//            const DATA = "MidswRhgG6b7SUR9vtzX5HfGKxVOWsmxoFqfXVzeasLpe3EYGU63NG5LYrcPh2NGKTf9mLQr3WkbqoEAE2YeamYItM8VwQ/kURRXCltEKPnYtreOWIteaFrepsPmdatkRIdt73/vgSapjS2HndkegrBtjcImgvtP314IIbZtOKqpf8zUK+kclufL3OpcHML7u/MZwFooPcUCmUCuSTi/hFXStPh537jqqy/pNgOXM2GjsyuFyMwt9fD8tF6gI8LfaTYCfZ9eV0fBu3I3qIskM4d/mZEP9pUXph7x2mRWaV3d5CdfQL1/O1OGA3A/+SKcMBN6XygIZxcLMXhj3V8j4cl5qRGfeBNZ6xKxYxQmow78Bf0qY6uLdoY6dD8spXIJiOay0K7Z/fHbQZe9mjxmyVLNPoIQ8HGkX5jMNP6AGUOokP6aZ2FAEuP9huuDSByhBb4G1uBscvxlJrjjWhoXCrv18w+C66i82RBEZ8QH0oyYC0z6Q+9cGRpsvPqYNA3/DaFM0TljR/TdWVqnLDqZIgQOgV2SXAXIzYjiInhtLM1y3nkDBWhZWtz9/TDNMaE82oCJhxPb5VlPvyL5AdMMZE/52vovdRH6qFyXMjUscEJiNFSy1nCo/x+BESCTv4VUaEIaH79x1ihqi6rTYUmwN1Meb2PUOS06cd1piHB9B1sZSjz2uT3Ddp/eKnNGTW+JeNC2lIj/wsz2peLUdKLrhF5KcmelN3NUvHbX9kymtL47ZEikYmC/iodBVkKWmGocPf4/bT9gpt++A0m03EvAgWg8s1+26WE744tDd+dnHBCn8NvkGyxnRYn7STbB3Dvdco+XyRF8vdFg0/un0UN6IzSaFoPfx57lbqrRZA8jdLm+qv6LX9ntxebXAkfveSW75GZokUecIk2SuWvO0l+hFpHsxrR8E+tDJHojktcAONWdQL4sLS8YDBqqwvr4dX3KcVXChg2U1Woht9W5/l5nO6wgB1WjyLJy/anDSuUDFMEVwUoYMxv3JHLzW61mafLl9XEVe43spdnOLN9HGNfvdaXHZCHjkprq+6hxuUgu9KwWWrxCn2p4jIm+52aKCNOWLfAtfrhyjJ6UBH2+RRQ+WY63Ssu2T74UKwp1oo+RUAjp05nvmS80MQmRiIaALibRIVYIFGtzFPivkYNAkeo0dcXz91ezM29XsBA0RKPNEHx87VqZE58O41oCUd420+06fZH01oJW8zkp/9GLq40flQMAQO7DEQ2wM208IoNJWHcVB0c+tj7HN2+umDUWYwbzKKDCToXGVYt1QthemHEFfLuEqHktFPzOCwC9GJEgdMbPewzapvM8G3F9/6bRA8zs";
//            </script>

            val triples = ArrayList<EncryptItem>()
            var item: EncryptItem? = null
            res.body?.byteStream()?.bufferedReader()?.forEachLine {
                val pureLine = it.trim()
                if(pureLine.startsWith(KEY)) {
                    // '"A+oU4zilpXm4Q1wKlK1lTQ==";'
                    item = EncryptItem(pureLine.substring(KEY.length,pureLine.length - 2),"","")
                } else if(pureLine.startsWith(IV)) {
                    item?.sencond  = pureLine.substring(IV.length,pureLine.length - 2)
                } else if(pureLine.startsWith(DATA)) {
                    item?.third  = pureLine.substring(DATA.length,pureLine.length - 2)
                    item?.apply {
                        triples.add(this)
                    }
                }
            }

//            println("zfc  ${triples}")

            triples.forEach { entry->
                val r = AESDecrypt.decrypt(entry.first, entry.sencond, entry.third)
                if(r.contains("><strong><span>") && r.contains("</span></strong></a></li>")) {
                    val startI = r.indexOf("><strong><span>") + "><strong><span>".length
                    val endI = r.indexOf("</span></strong></a></li>")
                    if (startI <= endI) {
                        val name = r.substring(startI, endI) .replace("<br>"," ")
                        println("name = $name")
                    }
                }
            }

//            val sr = SAXReader()
//            val newConntent = content?.substring("<!doctype html>".length).subSequence("<html xmlns=\"http://www.w3.org/1999/xhtml\" xml:lang=\"en-US\" lang=\"en-US\">".length)
//            val doc = sr.read(newConntent)
//            val x = "//*[@id=\"review-body\"]/div/ul/li/a/strong/span"
//            val n = doc.selectSingleNode(x)
//            println("${n.name} : ${n.text}")

//            doPaser(content)
        } else {
            println("error code ${res.code}")

        }
//        call.enqueue(object : Callback {
//            override fun onFailure(call: Call, e: IOException) {
//                println("onFailure")
//            }
//
//            override fun onResponse(call: Call, response: Response) {
//                if (response.code == 200) {
//                    // 打印请求信息
//                    println(response.body?.string())
//                }
//            }
//        })
    }

    private fun doPaser(content: String?) {

    }
}