package com.google.android.gms.location.places;

import com.samsung.android.spaytui.SPayTUIException;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import org.bouncycastle.asn1.eac.EACTags;
import org.bouncycastle.crypto.macs.SkeinMac;
import org.bouncycastle.crypto.tls.CipherSuite;
import org.bouncycastle.crypto.tls.EncryptionAlgorithm;
import org.bouncycastle.crypto.tls.ExtensionType;

public class PlaceTypes {
    public static final Set<Integer> ALL;
    public static final Set<Integer> zzanR;
    public static final Set<Integer> zzanS;

    static {
        zzanR = Collections.unmodifiableSet(new HashSet(Arrays.asList(new Integer[]{Integer.valueOf(SPayTUIException.ERR_TZ_COM_ERR), Integer.valueOf(SPayTUIException.ERR_TZ_ACCESS_DENIED), Integer.valueOf(SPayTUIException.ERR_TZ_TA_NOT_AVAILABLE), Integer.valueOf(Place.TYPE_COUNTRY), Integer.valueOf(Place.TYPE_FLOOR), Integer.valueOf(Place.TYPE_LOCALITY), Integer.valueOf(Place.TYPE_POST_BOX), Integer.valueOf(Place.TYPE_POSTAL_CODE), Integer.valueOf(Place.TYPE_POSTAL_CODE_PREFIX), Integer.valueOf(Place.TYPE_POSTAL_TOWN), Integer.valueOf(Place.TYPE_PREMISE), Integer.valueOf(Place.TYPE_ROOM), Integer.valueOf(Place.TYPE_ROUTE), Integer.valueOf(Place.TYPE_STREET_ADDRESS), Integer.valueOf(Place.TYPE_SUBLOCALITY), Integer.valueOf(Place.TYPE_SUBLOCALITY_LEVEL_1), Integer.valueOf(SkeinMac.SKEIN_1024), Integer.valueOf(Place.TYPE_SUBLOCALITY_LEVEL_3), Integer.valueOf(Place.TYPE_SUBLOCALITY_LEVEL_4), Integer.valueOf(Place.TYPE_SUBLOCALITY_LEVEL_5), Integer.valueOf(Place.TYPE_SUBPREMISE)})));
        zzanS = Collections.unmodifiableSet(new HashSet(Arrays.asList(new Integer[]{Integer.valueOf(SPayTUIException.ERR_TZ_COM_ERR), Integer.valueOf(SPayTUIException.ERR_TZ_ACCESS_DENIED), Integer.valueOf(SPayTUIException.ERR_TZ_TA_NOT_AVAILABLE), Integer.valueOf(Place.TYPE_COUNTRY), Integer.valueOf(Place.TYPE_LOCALITY), Integer.valueOf(Place.TYPE_POSTAL_CODE), Integer.valueOf(Place.TYPE_POSTAL_CODE_PREFIX), Integer.valueOf(Place.TYPE_POSTAL_TOWN)})));
        Integer[] numArr = new Integer[EACTags.SECURE_MESSAGING_TEMPLATE];
        numArr[0] = Integer.valueOf(1);
        numArr[1] = Integer.valueOf(2);
        numArr[2] = Integer.valueOf(3);
        numArr[3] = Integer.valueOf(4);
        numArr[4] = Integer.valueOf(5);
        numArr[5] = Integer.valueOf(6);
        numArr[6] = Integer.valueOf(7);
        numArr[7] = Integer.valueOf(8);
        numArr[8] = Integer.valueOf(9);
        numArr[9] = Integer.valueOf(10);
        numArr[10] = Integer.valueOf(11);
        numArr[11] = Integer.valueOf(12);
        numArr[12] = Integer.valueOf(13);
        numArr[13] = Integer.valueOf(14);
        numArr[14] = Integer.valueOf(15);
        numArr[15] = Integer.valueOf(16);
        numArr[16] = Integer.valueOf(17);
        numArr[17] = Integer.valueOf(18);
        numArr[18] = Integer.valueOf(19);
        numArr[19] = Integer.valueOf(20);
        numArr[20] = Integer.valueOf(21);
        numArr[21] = Integer.valueOf(22);
        numArr[22] = Integer.valueOf(23);
        numArr[23] = Integer.valueOf(24);
        numArr[24] = Integer.valueOf(25);
        numArr[25] = Integer.valueOf(26);
        numArr[26] = Integer.valueOf(27);
        numArr[27] = Integer.valueOf(28);
        numArr[28] = Integer.valueOf(29);
        numArr[29] = Integer.valueOf(30);
        numArr[30] = Integer.valueOf(31);
        numArr[31] = Integer.valueOf(32);
        numArr[32] = Integer.valueOf(33);
        numArr[33] = Integer.valueOf(34);
        numArr[34] = Integer.valueOf(35);
        numArr[35] = Integer.valueOf(36);
        numArr[36] = Integer.valueOf(37);
        numArr[37] = Integer.valueOf(38);
        numArr[38] = Integer.valueOf(39);
        numArr[39] = Integer.valueOf(40);
        numArr[40] = Integer.valueOf(41);
        numArr[41] = Integer.valueOf(42);
        numArr[42] = Integer.valueOf(43);
        numArr[43] = Integer.valueOf(44);
        numArr[44] = Integer.valueOf(45);
        numArr[45] = Integer.valueOf(46);
        numArr[46] = Integer.valueOf(47);
        numArr[47] = Integer.valueOf(48);
        numArr[48] = Integer.valueOf(49);
        numArr[49] = Integer.valueOf(50);
        numArr[50] = Integer.valueOf(51);
        numArr[51] = Integer.valueOf(52);
        numArr[52] = Integer.valueOf(53);
        numArr[53] = Integer.valueOf(54);
        numArr[54] = Integer.valueOf(55);
        numArr[55] = Integer.valueOf(56);
        numArr[56] = Integer.valueOf(57);
        numArr[57] = Integer.valueOf(58);
        numArr[58] = Integer.valueOf(59);
        numArr[59] = Integer.valueOf(60);
        numArr[60] = Integer.valueOf(61);
        numArr[61] = Integer.valueOf(62);
        numArr[62] = Integer.valueOf(63);
        numArr[63] = Integer.valueOf(64);
        numArr[64] = Integer.valueOf(65);
        numArr[65] = Integer.valueOf(66);
        numArr[66] = Integer.valueOf(67);
        numArr[67] = Integer.valueOf(68);
        numArr[68] = Integer.valueOf(69);
        numArr[69] = Integer.valueOf(70);
        numArr[70] = Integer.valueOf(71);
        numArr[71] = Integer.valueOf(72);
        numArr[72] = Integer.valueOf(73);
        numArr[73] = Integer.valueOf(74);
        numArr[74] = Integer.valueOf(75);
        numArr[75] = Integer.valueOf(76);
        numArr[76] = Integer.valueOf(77);
        numArr[77] = Integer.valueOf(78);
        numArr[78] = Integer.valueOf(79);
        numArr[79] = Integer.valueOf(80);
        numArr[80] = Integer.valueOf(81);
        numArr[81] = Integer.valueOf(82);
        numArr[82] = Integer.valueOf(83);
        numArr[83] = Integer.valueOf(84);
        numArr[84] = Integer.valueOf(85);
        numArr[85] = Integer.valueOf(86);
        numArr[86] = Integer.valueOf(87);
        numArr[87] = Integer.valueOf(88);
        numArr[88] = Integer.valueOf(89);
        numArr[89] = Integer.valueOf(90);
        numArr[90] = Integer.valueOf(91);
        numArr[91] = Integer.valueOf(92);
        numArr[92] = Integer.valueOf(93);
        numArr[93] = Integer.valueOf(94);
        numArr[94] = Integer.valueOf(95);
        numArr[95] = Integer.valueOf(96);
        numArr[96] = Integer.valueOf(SPayTUIException.ERR_TZ_COM_ERR);
        numArr[97] = Integer.valueOf(SPayTUIException.ERR_TZ_ACCESS_DENIED);
        numArr[98] = Integer.valueOf(SPayTUIException.ERR_TZ_TA_NOT_AVAILABLE);
        numArr[99] = Integer.valueOf(SPayTUIException.ERR_INVALID_INPUT);
        numArr[100] = Integer.valueOf(Place.TYPE_COUNTRY);
        numArr[ExtensionType.negotiated_ff_dhe_groups] = Integer.valueOf(Place.TYPE_FLOOR);
        numArr[EncryptionAlgorithm.AEAD_CHACHA20_POLY1305] = Integer.valueOf(Place.TYPE_GEOCODE);
        numArr[CipherSuite.TLS_DHE_RSA_WITH_AES_128_CBC_SHA256] = Integer.valueOf(Place.TYPE_INTERSECTION);
        numArr[CipherSuite.TLS_DH_DSS_WITH_AES_256_CBC_SHA256] = Integer.valueOf(Place.TYPE_LOCALITY);
        numArr[CipherSuite.TLS_DH_RSA_WITH_AES_256_CBC_SHA256] = Integer.valueOf(Place.TYPE_NATURAL_FEATURE);
        numArr[CipherSuite.TLS_DHE_DSS_WITH_AES_256_CBC_SHA256] = Integer.valueOf(Place.TYPE_NEIGHBORHOOD);
        numArr[CipherSuite.TLS_DHE_RSA_WITH_AES_256_CBC_SHA256] = Integer.valueOf(Place.TYPE_POLITICAL);
        numArr[CipherSuite.TLS_DH_anon_WITH_AES_128_CBC_SHA256] = Integer.valueOf(Place.TYPE_POINT_OF_INTEREST);
        numArr[CipherSuite.TLS_DH_anon_WITH_AES_256_CBC_SHA256] = Integer.valueOf(Place.TYPE_POST_BOX);
        numArr[EACTags.APPLICATION_RELATED_DATA] = Integer.valueOf(Place.TYPE_POSTAL_CODE);
        numArr[EACTags.FCI_TEMPLATE] = Integer.valueOf(Place.TYPE_POSTAL_CODE_PREFIX);
        numArr[112] = Integer.valueOf(Place.TYPE_POSTAL_TOWN);
        numArr[113] = Integer.valueOf(Place.TYPE_PREMISE);
        numArr[114] = Integer.valueOf(Place.TYPE_ROOM);
        numArr[EACTags.DISCRETIONARY_DATA_OBJECTS] = Integer.valueOf(Place.TYPE_ROUTE);
        numArr[116] = Integer.valueOf(Place.TYPE_STREET_ADDRESS);
        numArr[117] = Integer.valueOf(Place.TYPE_SUBLOCALITY);
        numArr[118] = Integer.valueOf(Place.TYPE_SUBLOCALITY_LEVEL_1);
        numArr[119] = Integer.valueOf(SkeinMac.SKEIN_1024);
        numArr[EACTags.COMPATIBLE_TAG_ALLOCATION_AUTHORITY] = Integer.valueOf(Place.TYPE_SUBLOCALITY_LEVEL_3);
        numArr[EACTags.COEXISTANT_TAG_ALLOCATION_AUTHORITY] = Integer.valueOf(Place.TYPE_SUBLOCALITY_LEVEL_4);
        numArr[EACTags.SECURITY_SUPPORT_TEMPLATE] = Integer.valueOf(Place.TYPE_SUBLOCALITY_LEVEL_5);
        numArr[EACTags.SECURITY_ENVIRONMENT_TEMPLATE] = Integer.valueOf(Place.TYPE_SUBPREMISE);
        numArr[EACTags.DYNAMIC_AUTHENTIFICATION_TEMPLATE] = Integer.valueOf(Place.TYPE_TRANSIT_STATION);
        ALL = Collections.unmodifiableSet(new HashSet(Arrays.asList(numArr)));
    }

    private PlaceTypes() {
    }
}