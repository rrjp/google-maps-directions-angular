import org.junit.Ignore;
import org.junit.Test;
import org.junit.Assert;

import org.reyes.googlemapsdirections.model.GoogleMapDirections;
import org.reyes.googlemapsdirections.util.jsonparser.JacksonFactory;

/**
 *  Unit test the server. Comment out the @Ignore to actually run the tests.
 */
public class RestServerTest
{
    static final String cs_googleJson = "\n" +
            "\n" +
            "{\n" +
            "  \"routes\": [\n" +
            "    {\n" +
            "      \"bounds\": {\n" +
            "        \"northeast\": {\n" +
            "          \"lat\": 45.5017123,\n" +
            "          \"lng\": -73.5672184\n" +
            "        },\n" +
            "        \"southwest\": {\n" +
            "          \"lat\": 43.6533103,\n" +
            "          \"lng\": -79.3827675\n" +
            "        }\n" +
            "      },\n" +
            "      \"copyrights\": \"Map data ©2015 Google\",\n" +
            "      \"legs\": [\n" +
            "        {\n" +
            "          \"distance\": {\n" +
            "            \"text\": \"541 km\",\n" +
            "            \"value\": 540536\n" +
            "          },\n" +
            "          \"duration\": {\n" +
            "            \"text\": \"5 hours 17 mins\",\n" +
            "            \"value\": 19010\n" +
            "          },\n" +
            "          \"end_address\": \"Montreal, QC, Canada\",\n" +
            "          \"end_location\": {\n" +
            "            \"lat\": 45.5017123,\n" +
            "            \"lng\": -73.5672184\n" +
            "          },\n" +
            "          \"start_address\": \"Toronto, ON, Canada\",\n" +
            "          \"start_location\": {\n" +
            "            \"lat\": 43.6533103,\n" +
            "            \"lng\": -79.3827675\n" +
            "          },\n" +
            "          \"steps\": [\n" +
            "            {\n" +
            "              \"distance\": {\n" +
            "                \"text\": \"0.3 km\",\n" +
            "                \"value\": 280\n" +
            "              },\n" +
            "              \"duration\": {\n" +
            "                \"text\": \"1 min\",\n" +
            "                \"value\": 36\n" +
            "              },\n" +
            "              \"end_location\": {\n" +
            "                \"lat\": 43.6557259,\n" +
            "                \"lng\": -79.3837332\n" +
            "              },\n" +
            "              \"html_instructions\": \"Head <b>north</b> on <b>Bay St</b> toward <b>Hagerman St</b>\",\n" +
            "              \"polyline\": {\n" +
            "                \"points\": \"e`miGhmocNgBf@cBb@KBoFdB[H\"\n" +
            "              },\n" +
            "              \"start_location\": {\n" +
            "                \"lat\": 43.6533103,\n" +
            "                \"lng\": -79.3827675\n" +
            "              },\n" +
            "              \"travel_mode\": \"DRIVING\"\n" +
            "            },\n" +
            "            {\n" +
            "              \"distance\": {\n" +
            "                \"text\": \"2.5 km\",\n" +
            "                \"value\": 2492\n" +
            "              },\n" +
            "              \"duration\": {\n" +
            "                \"text\": \"6 mins\",\n" +
            "                \"value\": 331\n" +
            "              },\n" +
            "              \"end_location\": {\n" +
            "                \"lat\": 43.6618361,\n" +
            "                \"lng\": -79.3545312\n" +
            "              },\n" +
            "              \"html_instructions\": \"Turn <b>right</b> onto <b>Dundas St W</b>\",\n" +
            "              \"maneuver\": \"turn-right\",\n" +
            "              \"polyline\": {\n" +
            "                \"points\": \"iomiGhsocNCWi@gEGc@?CAASaB[}BGk@E_@G_@M}@?E?CAI?I@M?EZyB\\\\{B?QSqBq@iF[wBe@qDm@{Eo@{ECGEIEIGEII]QOMQMKMOQKQIOIQISESIWEUESCYAWA]?]D}@?GAKAMe@_Da@oCi@}DYsB[yB]aCCUYuB_@wC]qCa@wCa@sC[gC]eCa@iCUcBM_AWgBcAiH]aCq@wEEUUoDUoD\"\n" +
            "              },\n" +
            "              \"start_location\": {\n" +
            "                \"lat\": 43.6557259,\n" +
            "                \"lng\": -79.3837332\n" +
            "              },\n" +
            "              \"travel_mode\": \"DRIVING\"\n" +
            "            },\n" +
            "            {\n" +
            "              \"distance\": {\n" +
            "                \"text\": \"0.2 km\",\n" +
            "                \"value\": 209\n" +
            "              },\n" +
            "              \"duration\": {\n" +
            "                \"text\": \"1 min\",\n" +
            "                \"value\": 18\n" +
            "              },\n" +
            "              \"end_location\": {\n" +
            "                \"lat\": 43.6635765,\n" +
            "                \"lng\": -79.3554817\n" +
            "              },\n" +
            "              \"html_instructions\": \"Turn <b>left</b> onto the <b>Don Valley Parkway</b> ramp\",\n" +
            "              \"polyline\": {\n" +
            "                \"points\": \"ouniGx|icNUJy@^oBz@u@Zc@Nk@PEBCBKN\"\n" +
            "              },\n" +
            "              \"start_location\": {\n" +
            "                \"lat\": 43.6618361,\n" +
            "                \"lng\": -79.3545312\n" +
            "              },\n" +
            "              \"travel_mode\": \"DRIVING\"\n" +
            "            },\n" +
            "            {\n" +
            "              \"distance\": {\n" +
            "                \"text\": \"12.9 km\",\n" +
            "                \"value\": 12906\n" +
            "              },\n" +
            "              \"duration\": {\n" +
            "                \"text\": \"10 mins\",\n" +
            "                \"value\": 583\n" +
            "              },\n" +
            "              \"end_location\": {\n" +
            "                \"lat\": 43.76282690000001,\n" +
            "                \"lng\": -79.33669359999999\n" +
            "              },\n" +
            "              \"html_instructions\": \"Merge onto <b>Don Valley Pkwy N</b>\",\n" +
            "              \"maneuver\": \"merge\",\n" +
            "              \"polyline\": {\n" +
            "                \"points\": \"k`oiGvbjcNiBXyCl@wAXw@RmEv@ODgB^uBb@MB}Bb@qBb@_AVWJSHm@T{@b@gAt@q@f@w@p@uChCgB|Au@p@a@\\\\o@d@o@d@y@j@e@X]Pm@Z]N}@\\\\qA`@}@\\\\k@Ns@RiCb@aBXyARkCXcDToBHmBJqAHiAHo@BcABYAg@COAWEQEYGSEu@Wo@U{@Yy@[q@WgCcAk@Sk@Qm@S}@Uc@G]EcAIo@Cs@Cu@?s@?q@?s@AyAIu@Gi@I_@Gy@Og@Mc@I_@Ke@OYK_@Qq@Wo@[gAi@c@YeAw@}@q@a@]]Yc@c@g@i@a@e@o@w@{EwFo@y@{AmBiB{BkGaIW]Y_@MQs@kA[k@Wm@Wo@Sq@Ss@Oq@Mq@Ku@Ku@Iw@Ew@CcAA}@@aBDcAFyAFaALgBf@{HJyAJaCBqA@o@?q@Ac@Am@G_AEe@Gk@OgAMy@UcAOk@k@eBSc@Ym@MWS]c@u@[g@[e@{CeEcAaBWg@Wm@e@mAGQe@uAWu@]iAaAkDe@eBSi@Wo@Wm@[o@_@m@W_@SUw@_AOQ[YSO[UQKUMQG]QOEk@Q[IsA[a@GwAU}AQ}@Ms@M_AK}@Mg@IMCMAy@Qk@Qe@QQGe@SWOYOYUQO[W]_@]]Y]W]c@m@{@uAyCqEMSyBeDk@y@Ya@SWW]a@i@a@a@YUq@k@oAs@[Oq@USG]KYG]GSCi@Co@As@@e@BYDw@J{@Rk@R]Le@Ta@RSLKHUNKHURWTa@^YXcDdDa@`@e@`@m@h@aBdA{BrA{@b@oDdBwAj@kBh@oBd@q@N{@L}BRiCRyAJC@c@@i@Bg@@qABu@AuCFkDFcEFyADiBHqAJoBP_D\\\\wBRaDX}Fx@uCb@yFv@}Dd@kAJs@Dk@@u@Bw@?}A@{B@{AAwBAeB?qBB]?]B{DRmCTuIjAmATkC^uARoALy@HmAHcCHyBH{AB{AFiADoAH[B{E^[DC?q@HoC`@_C^sAXyAZeB^yA^e@LK@{Ad@kAZkBd@u@NQBkAP}@N{@LuHlA{AVs@J_HfAcANcAL\"\n" +
            "              },\n" +
            "              \"start_location\": {\n" +
            "                \"lat\": 43.6635765,\n" +
            "                \"lng\": -79.3554817\n" +
            "              },\n" +
            "              \"travel_mode\": \"DRIVING\"\n" +
            "            },\n" +
            "            {\n" +
            "              \"distance\": {\n" +
            "                \"text\": \"0.2 km\",\n" +
            "                \"value\": 203\n" +
            "              },\n" +
            "              \"duration\": {\n" +
            "                \"text\": \"1 min\",\n" +
            "                \"value\": 10\n" +
            "              },\n" +
            "              \"end_location\": {\n" +
            "                \"lat\": 43.7646516,\n" +
            "                \"lng\": -79.3367198\n" +
            "              },\n" +
            "              \"html_instructions\": \"Take the <b>ON-401</b> exit\",\n" +
            "              \"maneuver\": \"ramp-right\",\n" +
            "              \"polyline\": {\n" +
            "                \"points\": \"ulbjGhmfcNqA?gA@qA@iA@u@?\"\n" +
            "              },\n" +
            "              \"start_location\": {\n" +
            "                \"lat\": 43.76282690000001,\n" +
            "                \"lng\": -79.33669359999999\n" +
            "              },\n" +
            "              \"travel_mode\": \"DRIVING\"\n" +
            "            },\n" +
            "            {\n" +
            "              \"distance\": {\n" +
            "                \"text\": \"0.5 km\",\n" +
            "                \"value\": 520\n" +
            "              },\n" +
            "              \"duration\": {\n" +
            "                \"text\": \"1 min\",\n" +
            "                \"value\": 26\n" +
            "              },\n" +
            "              \"end_location\": {\n" +
            "                \"lat\": 43.76753739999999,\n" +
            "                \"lng\": -79.3334894\n" +
            "              },\n" +
            "              \"html_instructions\": \"Keep <b>right</b> at the fork, follow signs for <b>ON-401 E/Victoria Park Avenue/Warden Avenue</b>\",\n" +
            "              \"maneuver\": \"fork-right\",\n" +
            "              \"polyline\": {\n" +
            "                \"points\": \"axbjGnmfcNyBIcDIuACUCOAOESGWMOKQQKQIOIOEOGUEQEUCYAWAQ?WCuDC{C\"\n" +
            "              },\n" +
            "              \"start_location\": {\n" +
            "                \"lat\": 43.7646516,\n" +
            "                \"lng\": -79.3367198\n" +
            "              },\n" +
            "              \"travel_mode\": \"DRIVING\"\n" +
            "            },\n" +
            "            {\n" +
            "              \"distance\": {\n" +
            "                \"text\": \"23.3 km\",\n" +
            "                \"value\": 23332\n" +
            "              },\n" +
            "              \"duration\": {\n" +
            "                \"text\": \"13 mins\",\n" +
            "                \"value\": 768\n" +
            "              },\n" +
            "              \"end_location\": {\n" +
            "                \"lat\": 43.83811679999999,\n" +
            "                \"lng\": -79.07197540000001\n" +
            "              },\n" +
            "              \"html_instructions\": \"Keep <b>left</b> at the fork, follow signs for <b>ON-401 E</b> and merge onto <b>Ontario 401 Express</b>\",\n" +
            "              \"maneuver\": \"fork-left\",\n" +
            "              \"polyline\": {\n" +
            "                \"points\": \"cjcjGhyecNESAEAIAo@EaAIwAKoCY_HGmBAOAGAESc@GqFG_FAaAA{BC_HAkEAyB?qBAkC?oCAmCAsDAaF?{DAaDA}CCaCE{AEkBIiBGiAIqAIaAImAKkAOqAMiAQuAOmAUgBYkBSsA]gC[yB[mBUeBWaBm@{DCMSsAScB]eC_@mCg@gD[uBc@_DWcBYmBo@sEaAyGSoAs@_Fc@sCYeBo@qE]aC[aCuFs_@{@gGSsASuAwBeOiA{HM{@M{@eAmH_CmPM_AAAOsAwBoPm@yEo@kF_AeI{@aIWaC}@uHcI}s@oBgQg@mEiAkJkCcUy@uGeAwHq@uE{@yFiBaL_AkFy@oEi@wC]_B[_BmAcGoAyF}@_E{@yD_@}Ak@uB_@yAY}@s@_Ck@cBa@gAo@eB{@yBw@gBaAuBw@aBm@oA]q@oB_Ew@}A_@y@_@{@c@eA{@yBeA{Cu@cCw@qCU_As@{CYyAScAIg@Mq@a@iCOgAUgBWiCS}BI}@UsCYuDK{AQ{Bg@oGe@iGWgDUsCYyDmBkVWgDgAqNo@eI{@eL_@}EQeCqAqPiA{N_JqjAYiD[oEGsAImBEaDAmA?qA@cABwAB_ABy@FeAFiALmBH}@LkARsAVaBRyAf@kC|@{DxByItD}Nx@eDv@}Cv@aDz@sDTiAPcARmAPoALqAJiAHiAJoCB}@BcB?sBC_A?i@KuCOwBSmBMmAWaBKg@[eBYmAQo@s@eC[y@e@oAQ_@u@_Bc@{@gAqBqA{BqCuEmDyFiAiBgAgBwA_C_BkCqAwBeBuCwBsDa@w@Sc@Yi@Yi@a@s@Yi@Ye@KQo@gA}@eBy@_BeA{BaA}BuHiPuB}DI_@{DiHoCaFgC{EqK}S{BaEoE_IcMqT_BsCOWgHgMyBeD}@wAeDmFkB{Ca@m@uAyBoAqBaAcBw@uA]q@iA}B{@mBk@yAu@qBoCqHkDqJgB_F]_A[_AoAqDkDuJ}HiTqEgMkDuJSk@IUWo@{HoTeSuj@yCoIaCyGgA{CwAuDUk@_@cA_@eAAC?AAA?C@A?G\"\n" +
            "              },\n" +
            "              \"start_location\": {\n" +
            "                \"lat\": 43.76753739999999,\n" +
            "                \"lng\": -79.3334894\n" +
            "              },\n" +
            "              \"travel_mode\": \"DRIVING\"\n" +
            "            },\n" +
            "            {\n" +
            "              \"distance\": {\n" +
            "                \"text\": \"428 km\",\n" +
            "                \"value\": 427628\n" +
            "              },\n" +
            "              \"duration\": {\n" +
            "                \"text\": \"3 hours 57 mins\",\n" +
            "                \"value\": 14190\n" +
            "              },\n" +
            "              \"end_location\": {\n" +
            "                \"lat\": 45.2083667,\n" +
            "                \"lng\": -74.3482841\n" +
            "              },\n" +
            "              \"html_instructions\": \"Merge onto <b>ON-401 E</b>\",\n" +
            "              \"maneuver\": \"merge\",\n" +
            "              \"polyline\": {\n" +
            "                \"points\": \"gcqjGzvraNmAgDm@}AY{@M]k@}Aa@iAe@uAc@mAm@gBe@qAe@qAe@sAc@kAWu@Wu@i@wAAEe@qAc@oAqGmQ_Osa@a@kAQk@Wy@U}@Sq@Oq@UoAMk@Mu@WqBa@qDMeAq@{F{Ds\\\\G_@qCsUi@aEUsBWsBU_Cm@oFq@wF[uCWwBIq@[kCy@_H}@gHOkAm@mEyAoKUaBi@yCwBeN_@cCs@kEg@{CQkAkBgLyAiJw@_FcA{GuBkOEWCYESCSCSCS_@uC_@uC}AoLAQiAaKkA_KmCkUQsAcAsH{@qG{Kux@M}@wCcTeA}HCMoP{lA_C{PqAsJ}@sG]eC_@oCo@}EYqBOwAW_COiBIeAEw@Cc@MsCIqBEoAAu@C_CAaA?_B?_A@}@?}@HkDBiBBuADkBVcLHsDLoGHeDFkDJqFNoHFwCBiBF_CHqDBcAL}ENuHFeDJaD@o@@oADwAD}ADmAFwB@y@LcFVwKFsD@WJqFP}IDyB@wA?iA?}AA_BA}AEcBEuAGoBKsBKwAK}AM}AQaBUwBWoB[}B]aCWkB[sBQgAGe@]aC_@iC]eCgAwH{Eu\\\\c@}C}B_P}Lk{@_BcLeCeQmByMqBoMCQe@mCy@sEUkAs@sDcA}EuEwTUgAo@aDEUwA}GgBiIi@qCWgAS_AUuAQcA[}BIc@M_AuDwWc@}CAEIm@aAsG}B_PWqBCMMw@OgAgA_IKm@qAgJEYyBcPsDcWc@gDIk@AGMu@kAmIwGce@g@kDYsBKs@OiAYqBMaACMMgAMo@U}Ba@sE[oEOyCUuFMmHCyC?{BFwI?GB_CDoBHyBHmBJcBJaBHiAL_BNiBRwBVqBR_BVmBJs@L}@f@}Cl@eDd@yBJi@Ja@Z{Ah@wBr@qCnBsG`AoC\\\\cAZy@\\\\{@Xq@l@{ATg@z@mBv@}ALY`@u@p@qApA{BjAmB`BmCbAcBfCcEbBsCh@_Av@sAvAyC`B_E`@kAVs@\\\\iAh@iB~@uDf@}BVyAb@cC`@sCJ_A^yDT_DPwDB}@D{ABwA@qA?{@?iAA_AA}@CwACmAE}@Cm@GuAIkAMuBiLegBw@qLwAuTYiEW{D_BwVKaBk@yIy@aMw@mLuAqTc@oGO{BgE}o@wDel@w@{Lq@aKW_ESyCUiDQeCUsD_@yF[}EYqEO{BSoDSaDSkDqCyb@IkAI_AS{BMeAMmAIm@_@gCSsA[kB[{Aa@qBaA}D]oAe@aBUs@a@qAe@sAu@qBaAcCeCoGoKwXwCsHc@kAeBsEi@qAkB{EeAsCcByEk@gBm@mBQm@{AeF_AcD_B}FYiAoAiFa@cBg@yBQy@EQ{@kE[cBQ}@i@_Ds@gEo@sDQcAc@yCOiAk@sEa@kDIq@Gs@Ec@a@{DO{AQ{B_@mEUoCQ{BMkBKgBSqDOeDMeD{@uYc@gNi@mQAq@}Ami@u@qUe@sPoAab@CwBKqDEqBEwBIeDKo@AEIuBMsEOcFSsGe@cO]yHE}@E{@]eGa@kGWuD{@uJYoCWcCe@eEYaCkBiOqAiKmCqTg@}DIq@mBiOi@cEYcCwAyLiBcOkCaTeBuNkBkOy@qGKy@yAgLYaCQqAaBeNiB{NKy@kB{O_CqRiC{SqCeUQyAs@}FqAoKcAiIwAoL{@_HcBgNo@iFqAeKmAcKaAyHwBgQ_A}HcBgNq@qFcAgIi@oEs@sFcAkIsBwPeAsIaB{M_Ee\\\\w@sGy@uGY_Cg@mDq@cFmAwIc@eDoEc\\\\mBiNmA}IiAoIgA_Iu@oFm@qEwByOsAsJS}AwAmKsF}`@E[E[mEw[iD{VaFq^cByL_@kCgAoIQmAsDiXoAeJgE_[oA_JeAuHaAkHsAuJ}@yG{@_Gw@iGeFa`@oBmNgCeR}AgLyLa}@SyAkCuRKq@cF{^eA_IqAkJcDkVeBeMoCaSuKcx@_CkQkAiHIg@WqBi@uD_AeHi@{DkB_NgCgRqDgXo@kEc@gD]gCi@{D_A{GqBaO}Ly}@_@iCyG{f@kAwIgQaqA_@wCe@mDa@_DM{@MkAYmCSuBU{BQ{BQyBIsAIeACc@?ICYM}BSqEYwG}Aq]_A}S_@yHWkFQwDCk@Ag@KqCScHO}FKsEEwAGyAK}CU_Fa@gJOkDWaGW_FUcEQkCQmCk@gIG{@Ew@C]G{AIiBWmFCm@AKGgAQgEE}@E}@SeF[iHc@kKi@cMc@qK_@{IO}CK{BIwAGeAMyAM}AIo@Gu@a@eDWgB]uB_A{FaAeGkAiHaBoK[yB]yB]qBiBcL}L_v@uEwY}@uFcDkSiIch@eAaHiAiHQqASqAcBoKuAeJgBeLyAsJ_@gCKy@K}@Iu@KcAEm@GaAEs@CeAE_B?g@?m@?{@@}@@{@@]@]Bu@FeAFy@HcAH}@Jy@L{@T{AFYJi@ZsAb@yBhAcFdAsEjBmIr@uCbBuHfA}E`@qB\\\\kBVyAZwBR_BNqAJaAP_BDo@Da@LaBHuADy@Ds@D{@DiADeABaAB}A@uA@gB?cA?mACsBC}ACcACmACk@MsCGmAKyAMyASiBgEsd@uB}TQmBOcBUiC[wC]}CU{Aa@sCSwAMq@_@yBo@wD_@qBSaAkB_Js@wCo@uCg@uBKc@Kc@kAaFSaAk@_C_AaEe@mBi@eC]sAOw@Oq@s@aDoBiI}@}Ds@iCs@}BmAwDkAaDmAuCkAeCu@uAMW}AsCwAgC}AqCy@}A_@s@OYc@}@]{@k@wAi@}Ae@eBYiAUeAMs@QaAOiAOgAKeAIeAG_AEw@Ci@CaAC{@CyA?aCEkMGaP?yBCcF?eAC{AGgCGyAQ}BKaAMcAOmAg@gDYmBk@gDOo@Ke@c@cB[eA_@eAQk@o@}AkBgEgAcCsA_Dw@cBw@iBe@eAeAcC{AeDe@gAcA{Bq@{As@aBcAeC}@kCs@{By@qCq@mCe@qBaAqEc@oB_AgEm@sCcAqEq@aDoAuFS}@u@yD_B_I_AeFUsAk@iDKs@M{@U_BQwAYcCOuAOaBOoBQ_CQwCMwCKsBIqDCoAAg@A{BA{D?cABeDDuCH_DP}FJyCf@uNPcFLkDj@eOf@{Lh@oMTiFb@_LLcDVaGT}FH{AHoBJcBNuBNyANsAXyB\\\\sBXwA^aBTaATw@f@eBt@wBh@wA\\\\aAhEqLJYb@kA`@kAj@_Bf@qAVs@Rq@`@oARu@\\\\qANo@XsAPy@N{@Ly@ZqBPyAH{@JiAJqAJoADs@DaADuAB{@?a@BuA?}@?y@A{AAy@C_AEqAE_AIwAG{@KsAMwAG{@I{@Gy@MwAI{@KuAMwAWoDMyAMwAMwAOsB[qDsCw]o@aIcA}Lc@eFa@kF_AoLu@cJo@_IcA{LWaDWuC_@oDUcBy@yGaCgReAqIc@gD}@cHsAyK}@cHeBoNG_@WqBQuAo@eFaB}MIo@e@qDiAiJ[kCeAgIk@uE_@uCc@kDSaB[cCc@oDg@yDo@_Fw@uGs@wFq@mF_@{Co@}Eu@mGm@sEGg@g@}D}@gHg@aEc@_EQqBYuDO_CYuEGcAUuDM_COyBE}@KqAKkBOoCAQQkCg@yIm@wJGgAASs@{KUgEaAgPWeEYeFGaAc@eHK_BAOEg@c@oHg@eIk@oJaAsPu@aMcAwPGiAk@qJI}Ao@aKE{@_@{GWgEIqAGqAKcB]yFE_AYoEc@qHYyEa@uGk@kJc@cHYaFGy@s@_MIeA_@{EKoAs@kGOqAUwBQ{AOsAe@cEe@uE]aDg@mESmBSeBYkCSkBUkB]cD_@iDu@aHq@iGa@qDa@yD[sCYcCSmBW}BUuBg@oEc@gE]eDQ{Au@wG[{C]uCo@uFi@{EkEs`@sL{fAY}BWuB[oBm@}C{@aEEOa@_BOq@yBoJw@_DkB{G}@yCcAgDo@yBs@_Co@uBs@{B}@yCgAoDwEwOmHiVw@mCs@{BcAgDMc@w@iCq@yBk@kB]iAOk@k@iB_@mAc@wAg@eB_@mAwAwEiAwD}@yCs@}BUy@w@iC_A}CaA_Dw@iCe@_Bi@eBe@}A[eA]gAa@sA_@sA[cAg@qBQs@k@eC_@cBWyAYaBO_A]uBQgAWwAa@gCc@mC[gBy@gFy@cFs@gE{@iFk@kD}@}Ew@eD_@qAgAgDe@gAgA_Cq@oAu@oAIMU]iBaCaAeAs@u@y@y@c@c@{D{DuIwIuC}CsAkB{CiFcAmCwAsEg@_CeAqFoKik@oGa]mEaVmC{No@_EYaCg@eFe@wFIiAEmAIcDUyRMuIGqEEaDOmEGiAOeBYkCc@qCc@yBa@_Bc@}Ag@aBo@{A]{@g@aAy@}AiAiBkA_BoCmDwCuDuE}FwCuD_EeFq@{@eDeEaDcEc@m@u@_AeC_Da@g@cBwBsCmDwAgBqCkDkAaB_@m@q@qAmA}C]iAk@uBSu@SgAe@uCWmBO}AOyBQoDM}DWoGMaDk@cOUoFSoFM{C[{I_@oHSsCYiDs@aGqA}IM_AaAmGOaAqCiRsAkJuJeo@iB}K{@_Fw@{DkA}EaEuNw@qCmCgJeRcp@sE}OyA_Fa@wAe@aB]iAsAsEWy@q@iBi@yA}@uBqAqCqAcCoAuBaFaIeHcLeEaH_DcFkB}CaA{A_CcEwAgCoBcEgAqCq@iBi@aBwAsEuBuIg@wCo@{D_AuGkBsMmBwM}BwN_BsIqEyTcJ{c@YyAyDaRmAgG]yAc@cBe@cBc@yAa@qA[_AsByFcCqGg@_BkF_OkCyHoUgq@qBgG{@eDw@mEIa@Gg@Kq@E_@Gs@Iy@IkAE_AEs@I{CEcFAy@SqVEmEOoV?e@?m@?EAg@SgZq@}}@MeDIcBOqBOyAIk@o@iDq@oDg@cBkA_DsLsWsCsGsFwLWg@EI[o@uE_KmB}Do@cBkEeMqAkDAEQg@?AyAgEaDiJ{AoEcDqJc@mA}@aCm@aB]aAe@yAmGyQiA{CaCaHo@iBu@{BmDcK_C{GSm@uBgGyBqGqAqDmAcD_AcCmAcD{A{DuAmDoCgHmBeFiB{E_BiEqCmH{FgOqCiHm@}AeCyGyB{F{CeI{FgO_BcEuAqD}Ly[eIcTsDqJsAqDeFwMwByF_BgEk@{AiCyGqFsNy@yB{@_Cg@uAYaAg@aBU{@g@iBm@eCS_Ao@}CUoA]uBe@mCc@kC{@_Fs@gE_AyFwAuI]qBk@iDk@gDQeAw@sEWuA]sBg@wCg@_Da@aC[kBWaBe@mCm@oDc@aCc@kCYcBg@sCUyA]sB[mBUsA]sBe@iCu@qEc@mCy@yEk@gDk@kDk@eDe@mCuBgMc@iCe@qCq@cE}@gFeAqGs@eEk@eD{B}M{@iFgAoGm@qDoD_Tc@oCyAqIs@gEa@kC{@mFi@iDIk@EYmAmIyA}JoCcReDaUkA_I}AwKqA{IkA}HaBaLu@gF{@aGeAcH{CgSw@eFc@yC}AcKi@oDwAgJw@kFc@uCwAoJu@aF[mBuAmI}AmJgAyGeBeKy@eFgCwOWuA[oBc@mC]qB_A{FG]My@aA}F]sB_A}FUuAk@iDq@gEKg@QeAWsAMu@Ow@Oy@Mu@WuAe@kC]qBOw@Ow@]qB}@aF}CoQc@eCoAqHoAwHi@eDE]Kk@mCkPoAqHiAaHeCiOoCoPmAoHi@{C]sBa@iBEWg@{BaCcK_AsDi@oBg@_BuAoE_BcF]gAa@sAe@{AOg@}A{EeCeIUw@Yy@eF_PyD}LmCsIiBaGUu@W{@o@aCc@aBi@yBU_A_AgEYyAc@_Ca@wBy@uEYcBa@qCk@{D{@yF]}BeAyGoBsMcCkPyAuJq@yEmCsQaBqKqAwIc@wCkAwHgBsL{@yFiDmUcCmP_CsOaAuGqAyImBoM_BsKcA}G]wBq@{EiBuLaBwK{G}c@}AoKEQy@eGu@aFaAsGaA{G_AqGU_BMkAIq@MyAKiAM_BOcCGsAImBEwAAkAMaF?eGBcBF_CH}B@i@Bk@ZgFToCp@{Fb@_Dn@uDX{Av@sDrBgJxBgKhDyOZ{An@yDh@wD^aDP}AXaDRaDRaEHcEBeC@cCCaDAcAA_AEaBMgDK{BIgB]kEqBuXwAwRkAgPq@eJ_@cF]sE}Bk[IaA{K}{Ag@yHWeDWeD{AeSaCc\\\\k@aIk@cI_BgTkBcWuCia@q@gJ}@kL{H{fAGy@K_BM}AO{BcQacCqA}PCWkDgh@{AcSyLudBuFmv@aAeMyAcROkCyAqTsHkfA_MgfBqGmz@qAoQiAmPcBmUEg@cBwUoCk_@uCob@gEen@cPa{BmF{s@iAsNw@aKS{CYsDSqCWkDM_BQsCYmDYwDWiDk@kIYsD[kEO{A]qCIw@My@My@SsA]mBQ{@YuAa@kB[qAo@eCaA{De@mBGU{@gDe@kBo@eCg@mBe@kBe@kB[qASw@e@kBoCuKo@cC[qAUw@c@iBcA_Eo@eC[qA_BmGaC}IwAoF{@aDeA}Dq@cC[qAi@mBy@_DQu@]qAuAqFeA_Ey@aD_@{AqDoNI_@EOy@eDmAaF]uAQu@WqA_@qBSuAYsBOwAIy@G{@Gy@Eo@G_AGuAEgACyACyA?{A@yA@yAD{AFwADy@F}@PwBJwAH{@LyAHw@H_AFy@LwAHy@F{@NwAF{@LwAF{@B_@Fw@H{AFy@FyAD{@@_@Bw@FuDDiEA[AeEEsBE{AIcCMgCQuCOmBO{AQ_BOwAS}AW_B[qBq@mDiAsFe@{BgAoFoBoJ_AuEeA{E{DiRuHg_@Y{ASeAO}@YoB]eCQaBMkA]uDOuBO_CIoBI{BGwDCkCEmFWi[OeOKaOGgGK_NAgBE{DEwDEcCCsAG}BEwAGcAMiCQgDQgDOsCk@kKi@wK]uGcAwRk@wKMyBMkCc@gI]aH]qG]iHg@uJCe@Cc@OuCQ_EQcEMsEMoFMiHKsHQwJOiKSqLOiLMeJOsKIeHM_KOuKI}GQqKK{IMuIOqJIuEQ{KKgIIwFSeOKcIIeFI{FIgFIkFK_FMkHSmNYySOiK_@{WQcMKcGEmDMmIMmHYkOOaIOmICqBGsD?KEsC?KE{DIeFU{NIoGQuL?KGuEGqDGuFQqUImJEwEEsEImGEyBm@}b@?EGiDKoHEuCIsEWcMIoE[eNImEKuEOmHEsCGuBQoI]}Qa@sQSoJOqFYeLMgGE_B[}NWcM_@ySm@{ZKuFEeBCcB_@kR?YWkMCiAm@u^E{BKqCKuC[gHYmH_@cJ[kHe@aLWmGSoEQoE]iIQqEYoHMoDCwA?}@EoEAsEAsCCuEAwBA{A?wBAuC?uDAoE?oGAuFAkGCsECqFCoGAsDCqFCmHEkHEiICoHEeK?WCoHCyEC{CI_DMkEQkFUcGOaFQuE[gJUeGOoEIiCm@gQm@oQsAy_@{@cWM_HGgLG{U?}SCoc@Qoz@A}FEqOAwGC}GAcFAcFAaFAmFA}F?sAAkAGqBIsBQuBKkAMkAYoBIe@SgA}@qDWcAy@gCw@cCe@iBYiA_@mBYqBOkAW{CMsBGsBCkAAoA@mA@kA@{@Dw@JqBDg@NiBFi@^uCZaBVqA^{A|@_DRi@Ne@N_@p@{AlIiQrE}J^u@Ta@pBmEP_@jAcDZcARq@lAqFnAoFtBcJLg@bE{Qp@sCZuAf@uB~Iga@T_Ah@eCt@yCf@yBd@wBR_ALy@XgB`@qCR}AT{BPuBV_DJeBDc@HmA?GNqBRwDVmELwBH{AHuA^kH`@iHXuFPqCPyBXqC\\\\uC|@cGpA{HtC{OjC}NDWzAuIjBkKv@eEz@uE^qB\\\\sB~@mFd@oCTqARiAh@wC^yBRyALw@D]D_@F_@Hw@H{@J{@Hy@F_AH}@F}@HwADy@D}@D{@B_AB}@D}@b@oN\\\\gMZqK^mLBgABgAT{IHuC@yBA{BEkBIqBQ}BEe@IaAUeBOaAGc@SeAYoA]yAOi@Qm@]cAi@yAa@aAk@wAw@gBmCmG{AqDgE{J_AyBkAqCcB_EsByEeDyHgBeEM[Wm@Wo@Us@Uq@Me@i@qBIa@Ou@Ie@_@_CyC_SiAwHGc@_@_CCQ]aC_@kCYqBYmBo@kEi@mD[sBg@kDo@gEg@kD{@iF_@kC_@}Bw@uFUwAUuAe@cDs@{EQkAkA_Ii@qDc@wCe@}C_@gCg@kDQmAc@sCa@qCIe@Im@U{ASqAQiAKy@a@kC]{BmAqI[qB{@uFy@{FoAmISuAUyAMy@My@Ow@Ow@Ou@Ou@Os@Qu@Qs@Qq@Su@Ss@Sq@Uu@Wu@_@mAeA{C}@aCYu@c@mAe@oAWs@Ys@Ws@i@wA]_Ae@kAWs@Wq@Wq@Wq@Wq@c@kA_@aA]}@c@kAc@iAYs@uAqDo@cBo@aB}@_Co@cBEKi@wAy@}B}@}Bc@iAWo@Yo@Yo@[m@[k@]k@]g@o@_A_@e@_@e@a@c@a@c@c@a@c@a@c@]e@_@e@]c@YmAs@mAu@oBgAaAm@mAu@y@g@{@g@y@m@w@m@a@_@e@c@]]UW[]W[]e@a@g@_@k@k@}@m@cAi@gAYk@[s@O_@Sg@Oa@So@w@qBc@kAe@oAsAsD{BkGiB_FgEiL{AsEeAsCIWM_@{CmI}@cC_CkGqAsDyFwOEMgIwTaBuEcCuGmA}CeAqCeAsC_@iAa@mA]kA]oA[oAc@iBc@qBe@cCi@gDa@sCUiBQ_BQiBo@sG{Fwm@eA}KuAsOcBoQiBiRaCyVwAsNc@gEc@sEYeDQsBMqBOwBMsBKwBMqCs@oQ}@uU[kIU{FYcISoGKwCMiDGiBe@iN_@_Kg@gNs@gT[wI]gJg@qLMuCGgB[kG[wHk@{NkAqZk@mNIuBEwBKoEQqMGqDGsDGkEGmFEuDGoCEwBEwAG{AEuAGyAWkFk@wLUkEi@{JQoDg@{Ki@wKa@cIYiFQoDUiEYiFMqCMuBOqDIuBUmFSkEOqDYiGYiGWkFSqDa@aIg@_J_@eHc@_J_AkRk@yKa@eIOoDMqD[aKOkFIuDi@mSk@{SCs@Cs@SeHOoEEwAE{@IuASsCMwAIw@SiBQ}ASsAa@oCc@iCG[_@mBk@eCYqAm@gCm@eCiAwEcBeHw@aDiAuEeBgHiCsKwB{IeBgHeBgHk@gCWuAk@oE_@kCQsAOwA]kDUoCk@aHwAgQmBuUgBwTkAsNg@gGo@eIw@{J_@oE]iEQsBYoDUsCUqCa@gFu@}IiAkNEo@SaCQwBKwAkBeUM}Ae@wFUwC[oDYmDOsBGs@IeAKuAI_AEy@IuAE_AGsAC_ACu@Ac@CsAAe@AwA?y@?{@?{@?mABgB@c@@u@B}@DqAF}ABy@D{@F}@Bg@@OF{@J{APuBPeBHy@Hm@BSL}@F]LaAHe@DWJe@n@gD\\\\mBToALw@L{@Ly@PyAPqBB_@BYDy@HwB@w@BaA@wB@{A@sCHuODkHDaJFaLDcE?oD?_A?}@CyAAy@C{@Cy@Ey@E_AKuAIcAEe@KeAGc@Io@Ec@QkAUsAUuA_@qBaAgFkJgh@eN_v@eBmJu@aEg@kC_@iBg@kCa@mBs@cDYqAi@gCgA{Eu@_D]sAkAuESs@e@iBq@cCe@cBk@oBs@eC}AgF}AgFUu@sB{GuAqEsAqE}AeFqAqE_BmFeGgSiBcGg@aBy@kC{BwHiBeG}AgFsB}G_CyHs@_Ca@uAsHuV[gAgD}K}BwH_A{Cq@{BiAwDiBaGuAsE}AgFgAuDu@aCgImXeDaLiTat@qAqEg@iBi@qBi@_Cc@mBa@kBYsAYqAWsAg@kC]mBO}@i@gDYsBQqAYsB[mCi@_FU{B[kDc@}FMeCOwCKcBIiBKeDG_CEwAGsDCwBCsC?wC?oD@wBBsD@y@DyBFqCFsDTeKr@w]T}Jj@eYDwBDuB?wA?}@?iAAiBAyACsAK{CGwAKwBQeCSeCSwBAKSeBYwBi@{D_@qCg@oD_AyGg@mDs@_Fe@mDy@}Fy@wF]aCe@cDgF{^E]EUE]CUKs@y@cGq@{Eg@mD}@qGsB_OcAeH?Gm@qDg@cDs@gF_@kCc@qC_@oBa@mB_@sAe@cBa@sA_@gA[y@Yw@Yo@Yo@m@mAe@}@iEqH{BuDcCcEcCuEgAiBiAkBiAkBwAaCyAcC{@uAgAkByAeCwAaCuAaCiB{Cy@uAgAiBy@wA{@wAy@wAwAeC[m@e@cAc@{@_@{@c@cAc@iAc@iAa@iA_@kAa@oASs@]mAUy@YmA[qAa@oBi@kC[kBg@kCm@eDKm@Km@Mo@WwA]kB]kBWsAWuAa@iBUaA[gAMc@Og@Us@a@iAq@}Ae@eA[q@g@aA]k@_@m@wBiD{A_C{@oAm@_Am@}@}@uA{@qA{@sA{A_CkBsCiBqC}@sAi@aA{A}BiAgB}AaCyA{Bm@_A}@sAkAiB}@uA{@sAm@_A{@qA}@uAm@}@y@oAq@eA_AoAq@{@s@{@eAgAq@q@u@q@y@o@u@k@q@k@w@i@g@_@w@k@w@o@u@m@c@a@s@o@u@u@u@w@q@s@_@e@cAmAo@y@o@}@m@}@m@}@[i@QW[i@i@aA]o@[m@[m@Yo@Yk@Yo@q@}Aq@eBo@_B_A}Bq@aBgAqCc@iAcBeE_BaEiAuCkAsCUm@o@{AcAcC_AuBw@}AMU[m@i@aAMUMU]i@]k@kAeBw@eAyBqCiDyDwCgDeCsCqAyAuA_BsA}A_AgAc@e@u@u@a@a@QOw@o@w@m@iAs@{@c@UMc@SsAg@k@SQG}@UgB_@}D}@yHgBcH_BOEkDw@eFkAyFqA{D_A{D}@mA[uEgAuLwCsA[y@Si@Mk@O}@WSESGe@Oi@SgBq@e@S}@a@_Ae@e@Uq@_@o@a@[QgAu@eAw@}AkA_EyCmG}EgDgCmCqBoCuBmDmCqCsBgDgC}EqDwCyB{AkAyAiAkA{@{AiAkA}@YUkCoBoFcEoB{AwAgAWS{AkAKI_Au@kCqBaAu@cCmBeCkB_DcCyI{GaAs@_BmAiBuAi@a@aCiBmByAsAeAo@i@MKmBcBsCeCqCeCQQu@o@kBcBiBaBaDuCsCgC{BqByAqAu@q@iAcAa@_@w@q@yAsAkAiAaA_AkCoCuA{AgCsCuBcCaGwGoGiHqGiHkCyCq@u@uA{AeBqBaAgAeAkAiAsAo@q@_AeAwRsTcDyD]]eAkAqAyA{AcBiF_GSUkFeGgCoCkFgFoCsCw@w@wAuAyBkBuAuAwCyCoEsEy@y@gBiBs@u@mAoA_A}@u@w@a@c@kAmAqBqBwAwAo@q@UWOOgAgAyB{BsBuBW[YYUYQUW[MSIM]i@_@q@Yk@Yo@a@gAWu@Su@IYSw@G]GWG[OaAa@cD]sC_@qCo@eFiA}IaA}H]qCYuBqDyYs@sFi@kEUgBKs@uAeLWsBEa@I{@IeAEk@Ew@KgCEiACsCAyA@uBB{ADuANqCNwBPuBZoDp@eHrAsN~@}JHcAF{@F{@FcAFeBBcB?eA?q@CsACaAI{AIgAG_AKaASwAO_AMu@YuAQu@]oAe@{AsAaEqJmYwLk^{@eCs@oBaAiCg@mAs@_ByA_Dy@}A{@wAy@sA]i@q@aAo@}@o@{@q@s@c@c@c@a@y@o@y@i@w@a@]O[Kk@Qe@MaAQaAKy@Em@Ay@@q@BuCHaELcELqUx@sCJqIVsELmBBsA?yACaAE{@GuAKuAQmAQgASsAYiBa@sAa@qAa@uAi@mAg@{@_@iCsAmAs@s@c@k@a@aAq@m@e@y@q@s@m@u@s@iAeAcBkBeAmAoAaB_AuAe@u@e@u@sBqDqC_Fy@{A_D{FmHwM}N{W}K_SuF}JyDaHcB}CyAeC{@uAm@{@_AsAq@{@a@g@qA{AwA{AeAeAoBeBw@o@wAgA}@k@mBiAyBmAg@UoAk@{@_@iLkEyIgDiNkFyBy@s@Yq@YyB}@k@Ya@SmAs@YSYQ}@q@iA}@u@q@gAgAuBcCq@y@oEyFs@aAo@}@k@_Am@gAu@yAaAuBe@gAg@sA}AcEy@}BgAwCcGaPiBaFaAeCcJwVsD{JuC}H}@cCgB{E{@sBoAmCsAiCiAqBq@gAoAmBEEAAQSa@c@e@k@oAsBcBgCkAiBk@w@[c@kKePIMe@q@S[e@u@Wc@{BmDaDqEQYQWkAeBeA_B{@qAQYq@gAcD_F_B_CyBaDe@o@_AsAoAmBWa@Yc@u@kAuB_DoAqB_@k@a@i@oBaDiDqFuB_DOQaBaC_G}Iu@oAwHiLw@gAEGi@s@mBwCcA}AoAuBgBiCaBeCsAmBs@iAyAcC}BeEgAuBgAuBuAmCsFuKoAaCmBwDeIyOsEaJqIkPsCuF_@u@}CaGcDmGyAwCs@sAgAqBuAoCmBsDaAiBsAgCuAkCuAoCwAoCsAkCgB_DWa@q@gAyAuB_@g@}@iAeAqAi@m@i@i@s@u@wAsAkB_B}AsAiAaAmBaBwDcDkBaBs@o@{A{AsAyAcC{C}A{BqAqBgBqCm@cAwA{BgCcEaA{AqBcDoAoBwAaC{AaCkAiB{AcCq@eA[i@MS{BoD{EuHMSm@aAQU]k@{@sAm@aAk@}@mAmBu@mAq@eAeIsMoD}EcN{PwGkIsAcBmDmEmA{As@}@mA}AcAoA_AmAq@}@Y]mBeCoAaBu@aAw@eAiAuAqAcB}@gAo@w@kMcPiCaD_c@si@kL}NmBaCqCkDuCqDsAaBeEkFkEqFaBsBy@eAy_@af@iCaDsCqDgHaJaFiGeAsA_LqN{CyDcBwBcBwB_AkAgFsG_AkAgLyNgEmFeJgLuAgBoA}AoA}AaAoAaAkAsDwEgJmLq@{@oJuLgCcDgAuAqA}Aa@k@o@w@q@y@q@{@m@w@sAcBq@{@q@y@_@g@q@y@o@{@s@}@[c@SW[c@OU_@i@[g@i@}@Q[k@aA[m@i@cA]q@Yk@Ym@g@kAWo@e@mAWq@Um@Yw@Us@Sm@Ww@]mAUw@I]YgA]wAYmAWqAYyA]kBa@mC]uBYoB[sBc@oC[mBSwAMu@U{AYkBUyA[kBU{AKu@UyASqAUyA[mBSuA[qBc@oC[sBa@mC[oB[sB[sBWsAUoAQy@YqA[uASw@YkAi@iB_@oAQg@Mc@c@oAc@kA[y@Yu@Se@Yo@c@eA[o@]q@[m@[m@[m@i@_Ak@aAaBoCgKaQo@eAoEuHaJiOiGiKgB{CmDaGwBoDcCeEyAeCwBoDk@cAk@aAgByCsBgDqBgDoEqHU_@EGYg@{AeCgKoQqDgGeFsIsZch@sMuTuBoD}CkFqJaP]o@gTm^QYQYm@eA[q@cBwCiD}FEGmCqEiAiBuA}Bs@oAwDoGeCgEiDuFgAaBmBoCmB{BwA}AiBiBqC_Cu@m@s@g@_Ao@}@k@aAi@y@c@[OkEwBaCkAkCoAs@[aBy@wBeA{E_CiCoAuBeAoAm@aCkAsCsAkB{@_Ae@sAq@}@e@_Ag@}@i@{@m@cBmAoAcAe@a@g@c@{@w@y@u@g@g@w@{@w@}@mA{Aw@eAo@}@g@y@k@_AeA}AaAqBkAuBw@yAaByCwAkCeCuEsByDiBgDqBsDqAaC{AqCiC}EoBqDaIyNcKkR{Pq[sOoYwMoVkDsGuEuI{Yyi@kDqGaG{KoCcF{GgM}LeUm@kAIOk@cAaB_DiAsBcAmB_@m@gBmDsD_HoBqDuByDaAiBm@gAqAcCm@iAc@y@iAyBgBeDmCcFcB}CsAeCq@oAq@qAmAyBg@_AsAaCcCsEwDeHq@oAq@mAo@oAqBuDsBwDqA_CoA_C_DaGqBsDaB}CU_@kAaCsB}DqAcCqBuDqCkFwFeKsFeK_DaGmCcF{EcJ_CmEaD_GaDaGaJwPcCuEgCwEiDoGQYgCyEcAmBs@sAoVqd@uB}Dq@qAq@oAq@qAgCwEuAgCs@qAcIgO}BiE{FmK_@q@_@q@_@s@s@sA_@s@i@cACEcE{HcFkJSc@oF_KgAuBw@_Bu@}AM[mBmE]{@o@wAy@sBq@_B}@wBQa@m@wA}@wBo@}Ac@gAw@mB_@{@gAkCaAaCaA_CeBgEiAqCmAuCwh@ipAc@gA?Aw@kBcSif@_`A}}BgDeIaC_G_CyFeBeEwAoDoA}DiA}DcZajAUy@oQwq@mKea@gRcm@aOyc@uFkQsJcZcG{RgHuTySgq@qHgVsJm[oG_Ts@}BqGkSsR_n@oNqd@gEkN{Ku\\\\qBgGwG_S_EsLy@gC}AqEwCwIsA_EsAaEwCwIeFkOoF}OgEkMwBgHqGgTkKc^qGuTgA{DoFoQ_A}C}F_SqByGeCoIcCmIcH{UkI_YmDwLmHgWaMeb@_EgN{A_FsBcHuDeMaCiI_Ke]eB{Fu@qCcAaDoH}Vc@sAo@eBYq@Wg@]q@_@q@]q@w@oASYY_@q@{@k@q@y@y@eAaASQMK[UWQc@[YQ]Qc@Wa@QaAc@_@O]MsA][I}A[}Ew@}`@iGaAQc@Ia@Ia@IYGiA]e@O[MqAk@{@c@c@Y{@k@_@WWS_A{@c@c@]]c@e@[e@u@aAi@w@Ye@S]_@q@i@kAc@aAYu@[_AWy@Y{@sAmEmBmGuMyc@eCkImPuj@IWa^ulAsDcM_DmKuBcHoAcEsDeMs@eCy@gCu@iCm@qBs@cCi@iBi@gBy@sCk@iBs@aCyA_Fe@_Bu@iCoFuQmBsGoBwGqAmEaCcI_C_IuA{EaA_DuBiHeAiDuAwEeBuFmA}DcAeDqAiE_C{HcAoDs@gCaBuF}@}CgA{Dy@{C}AoFq@}BK_@Ss@{CcK_BqFM_@]qAgAoDm@wBcAgDoAeEe@_Bo@sBmAgEwAaFy@uCmAiEiAuDgAuDiAaEqAoEcAiDkBqGkAyD{@yCgAqDiAyD]iA]iAu@eC{ByHiHiViBiGuA}EqByG_BmFgBcGkBkGeFeQiC{I{BuH{CcKiCuI{AcF{AaFgB{Fq@}BcByFsBwGmBwGoDwLaGcSeFaQyAaFeH_V_EeNs@cC{GgUgAqDcCkIyAaFqCoJiBqGaBoGqGuWwA}F{@aDwEiRU{@Mk@mCuK{DuOiCeK{AeGoBkIkLod@mDgOyEmRyFsToKsb@?AaC{Jw@_Dq@kCmCsK_DiM{FcVm@oCMs@Mo@WwAw@aFa@sCg@oD}AwKgFs^qBgNm@gEy@eGaAgHoAeJ{AmKgAuHOqAS_BOaBOqAQmBMkBKcBIoBGsBEqB?mA@oA@uBDgCFwBFaBBe@HoAFcAHcALqAP{ANqA^sCRqANy@Hg@VmA^aBVeAj@qBz@wCnIqYzEaPpJc\\\\|B{H^sAbEcN|A{FBEFYrG_UzCiL|@}Ct@oC`AaEt@_Dr@iDp@gDn@gDj@iDv@gFl@iEh@mE^oDXsCZqD\\\\kERwCLqBFqAHwANaEJuCJsENoGRiJ^mOPcINyFN}GTuJZ}MVuKb@sQPiIHsDBcB@aA?mAAwCCwBOkJMgKG_DAsACuAKeGOmJMmHKmGMuHKiGAqAKyFKcGEcCKoHMkIKqHG{CCoAImFEaBGyAU_FAUG}@g@kFa@sDWqBKo@SsAOy@WuAOw@WsAe@qBm@eCYeAw@kCeAkDu@gC_BgFyAaFyA{E{BqHqAiEmAaEsAmEeB{FoAgEs@cCmFgQ}BuHiAyDi@oB[qAa@oBWuAMy@Kq@U}AOwAOyAKwAG{@G}@GyAE{ACwACaB?EGmFEiEYk\\\\S}SAw@IgFO_NEiEWeYk@im@SwNM_QEkBKiBMkBY{C{AkOkAuL}@aJq@qGKkAMkAu@yHkAmL?AkAaLqAsM[yCOkAMcAk@uCg@}Bs@kCi@gB_BgFsFuQmGySsCkJqMob@s@}BoCiJiBwFqLm`@qAeEeQ_l@aHgUcFuPmA}DgB_GcAgDa@sAgAmDq@yBe@yAQe@uGuSoAeEaAcDu@cC]eAiAwDk@iBq@mBWq@a@gAg@oAcAiCu@gB_F{LkAwCqA}CyAuDoJ{UkCqG_C_GoB_FqHaR_C{FsCgHuCiH}B{F}ByFoB}E_C}FoB_FwAoDiAsC}BwFa@gAw@wB}@{B{BwFkAsCiAsCwAmD}@{BuAmD}CcIsAoDy@_CyJiXyJkXKYqAmD{AgEuB}F_BmE{AiE_BkEeAuCeAuCo@eBcAuC}@cCa@iAy@}BgAyCeAuC{@_Cy@{By@_C{@_CeKeYWs@eB_FiBcFqD}J_CuGiBaFaCwGgAwCoAmDiBeFwIgV_BqEaC{GqAqDcFgNIW_AiCISoCqHiGyPgHwRm@aBo@eBo@cBc@kAe@gAYq@g@gAYm@{@cBcAiB}@wAk@aA]g@_@i@[e@a@i@q@}@_@c@q@{@s@{@eD{DsLoNcBoBaAkAaAkAaAmAs@{@o@{@o@{@o@_Ag@w@c@u@e@u@w@wAaAkBu@}Aw@kBcAkCYw@s@qBc@wAu@cCIUsQsl@iAsDq@}Bc@sAs@cCW{@}@{Cq@_C{@uCmBsG_BsF_@qAw@mC_CgIgDiL_A_DsAwEiAwD_BwFo@wBiAyDu@cCs@eCk@mBs@cCe@}Ac@yAq@aCk@mBu@eC]oAm@wBm@qB_@kAW_A}@}C_@qAk@iB]oA{@uC_AcDs@cCgBgGsCwJqAoE}BaIsAuEqAoEkLw`@wAaFsBeHqAsE}AoFsAsE{AoFiBiGqAuEsAuEgBiGwEiPgC}IoDeMgBiGs@eC_BcG}@gDcBoGaG{TwBeIuBaImFgS_DmLwBeIq@eCg@iBWw@Uo@Qc@Sc@Ym@Sa@Uc@Wa@U]U[Y_@]c@c@e@e@c@a@]USYQ[Ue@Y{Ay@gB_A}C_BkCuAqAq@KESMeB}@aB}@oAq@e@[e@]c@]e@a@q@w@QUQU]e@MSIKa@u@]o@Q_@Ug@Qa@Si@gAsC}@_Cy@wBoFqNkCaH}DiKcCsGaBiEsAmDM[cCqGy@wBeBoEkBaF_BeEsCmH_CgGqBmFeCsG_BcEACiAwCc@kAWq@eCsGqCkHcCsGiAsCiCoGWk@[q@e@cA\"\n" +
            "              },\n" +
            "              \"start_location\": {\n" +
            "                \"lat\": 43.83811679999999,\n" +
            "                \"lng\": -79.07197540000001\n" +
            "              },\n" +
            "              \"travel_mode\": \"DRIVING\"\n" +
            "            },\n" +
            "            {\n" +
            "              \"distance\": {\n" +
            "                \"text\": \"67.3 km\",\n" +
            "                \"value\": 67286\n" +
            "              },\n" +
            "              \"duration\": {\n" +
            "                \"text\": \"44 mins\",\n" +
            "                \"value\": 2660\n" +
            "              },\n" +
            "              \"end_location\": {\n" +
            "                \"lat\": 45.4623177,\n" +
            "                \"lng\": -73.6095157\n" +
            "              },\n" +
            "              \"html_instructions\": \"Continue onto <b>Autoroute du Souvenir/Autoroute 20</b><div style=\\\"font-size:0.9em\\\">Entering Quebec</div>\",\n" +
            "              \"polyline\": {\n" +
            "                \"points\": \"iw|rGvcxdMqC_GqAoCe@aA{AeDACsAqCmDoHwGmNcHcOcEsIu@aB_AqBaBkDwBsEsBkEUe@iB{DoAgCk@mAs@sAw@_BqAkC_AgB{@kBO_@O_@Wo@a@oAM_@I[IWK_@EQU{@WoAWwAa@{BUsA_@}BcGu^k@gDyAoIaGg]aBoJY}Ak@yCa@sB_@cBc@gB_@sA_@qAg@eBk@cBOg@Sg@e@mAy@qBo@}Aq@_Be@kA{@qB]y@mAwCg@kAmAyCaP_`@}@sBs@eBo@}Aq@_B{@uByAmDyDeJ]}@aBgEyCaIaFsMkCeHkCcHiDcJw@qBkCcHwB{FoCcHeBwEuCyHcCoGaCqG}AaEe@mAiCcHmCiHeDoIcA_CmAsCeK}SaC}E}B{EqCuFwBoEKWaAwBUe@uAaDcAgC}@aCk@}AeA}Cu@{Bs@}BYw@sN{c@c^yhAc@sA}@qCqA_EcAcDyB}Gu@_Ci@aBc@kAw@oBSe@Uk@y@gBcBeDi@aAs@mA_@o@e@w@e@s@a@k@]e@a@i@aAmAa@i@cC_De@m@MOiIwJ_d@sj@kAwA_O_RQUsNiQ[a@}BsCup@uy@sDqEuC}DY[W]sCmDkBcCc@m@kBkCiC{Dk@{@uAuBcA}AoEaHyBeDiBuCs@eAw@mAgBqCiDoFy@oAu@qAk@cAk@cA}@iB{@kBcAeCg@qAsEwMgJqXuIeW_B{E}AuEqGiRoDsKw@kC]eAm@oBqAeEgB{FiAsDcL{^{Sqq@}E_PyLi`@Mc@{A}EuMwb@iAmDm@sBaAyCiB_GiGiS}DiMaDiKgB}FwBcHeBwFyBeHMa@a@oA}Qam@iEgNu@eCuAqEoDiL_BkFUs@GQoQ{k@_AwCoBoGqPwi@sG}S}C}Ja@iA_BaFmA{DaAsCKYsDqLuAsEkDcLoEyN_BgFy@iCs@mBu@mB_AaCcA_CqAoC{AwCu@wAi@aAaA_BgDiFgBmCw@iAsB{CwH}KaDwE}BiDqAoBOSoAkBmAmB[e@k@}@oAsBS]gAgBiCgEmAsB{AeCkDyFuBoDqBeDWc@EEMUc@s@w@qAaG{JmEkHaBmCsAuBs@cAa@m@{@aAMMg@g@q@o@aAy@_DgC}AoAkCwB][IIYYuAuA}BgDu@oAcAsB_A{Bm@_BcBmEqFwNm@}A{ByF_@aA}@}BcDqIu@qBkAyCa@iAcAmCk@}A}AwDgAeCWo@a@}@i@mAi@kAWm@e@gA[y@o@yAeAiCcAiCgAqCa@}AQ}@QoAG}@G}AEmC[kSGgEMiHE_BCaDa@iUAm@Am@EgDIkEQuEIgBIqAMeBQkCc@_Fi@yFmAoMUqBKy@OyAIi@Ku@SuAGWWgB]qBg@mCc@sBYkAo@qCwAsF{BcJyHwZgAoEi@uBm@_CyAcG[mAW{@W_AWq@IUq@}Ag@gAk@eAMWw@qAEGg@u@Yc@[_@g@k@]e@}AsAu@o@}E_E}AoAgA{@y@m@eAy@_BmAeBwAqAiAwBqB}AsAkAaAIKi@c@ECQOgLoJGECCMK[YCAKKe@]g@e@w@u@[_@c@g@QWQWq@cAk@eAg@eAQa@g@kAa@gA[}@W}@Og@U_AS{@QaAUsASqA_AiHa@sCQiACSIk@OaAQsASsAUuAQaASaAS{@cAsDc@oA_@kAa@kAa@oA_@mA_@qAe@eBw@yCiAuEuAsFiAmEq@oCq@kCk@{Bi@yBa@eBU{@yAmGw@aDq@mCaA{DuDyNm@{BwAsFiAiEYaACKYgAcAiDiAiEwAqFiC_KYeAYeAkF{S{@oDmA_Fo@iCoBsH}AgGuAmF{@gDgAkEi@{Bs@gD_@iBe@}Ba@aCg@sC[mBm@aEWoB[cCUkB]yC[}CWyCSoBUeCSsBEg@O{AGg@[yC]sD_@kEg@yFmAiNYeD_AyKYaDc@}ESiC]mE]wE]cE[qDaAiLs@iIo@cHeA}L_AsKa@iEi@kGc@eFMuAg@wFEg@IwAMuA_@cDq@sFy@cGu@oEaAkF_AmF}AuIo@iDsEqWG_@Ie@ACIa@kAwGoDqSiBcKOy@uEyVqA_HiAoGa@{Bi@wCiCoNm@}DmAeI_CyOaAcHm@_FYaCgAaKsC}Va@gD_AgIaAuG_@sBKm@g@aCq@wCWcAe@cBq@}B_A{CcBsFwAqE_DaKiAoDs@_CYiAgAeEEO[}Am@{C[mBYgBg@kD_@}CU}B_@aFWcE[yFKaCGsAOgEEoAMqFCoAAaBAgDAmA@uGHaN?]DgF@uA?OF}IL}SRoa@h@sbAFqNBsB@iD?uBDiDH{CJ{CRyCDo@BWDg@t@wHd@_EdA}Jf@{EN}APwAFw@HaABs@Bq@By@?_@?{@?u@Ak@C{@Co@IeAEs@Gi@?GAEGa@Im@Ks@e@uCQeAe@wCa@cCMq@UyAMw@QsAKcAOcBEs@Es@Ae@A]?U?s@@mA@qC@wCBkD@uAF{K@_BD{FDiG@uC@{@@yAHcQ@}@?C@_ADeLDqI@kFB_CBaFHyODaJTe]H{NDyFBgHBoEBkE?kAF}KBkD?Q@Y?A?i@?C@a@@kB?}CHsEJoET_JFmBFaDFgCDeCHcLDiCDsFBmEDyHFoKF_I@mAB_F@gC@gADy@DgAHgALuAHs@Ly@Jy@TqAH_@VkARq@V}@z@sCd@{AbBoFj@gBH]l@qBb@cB\\\\{AlAyFvEcU\\\\iBHg@TyANeAXsBRgBHeAHoAFiC@q@h@qQBoA?g@?W?kAAy@Cs@Cm@Ca@AIUsBO_AOy@[uASs@Oc@EMIQOc@CGGOCESg@aAcCkCsGy@qBc@iA_ByDy@oBoAsCcBsDeEcJyAcDw@aBO]Q]{@oBGOAAu@kB{AwDk@wAwA{Do@eBKYu@sB{BsGYu@mAmDoBsF}AqEsA{Dc@qA}BwGuEmMo@}A_@}@qAyCuA}CaAuBiB_EyByEyB{EaFwKaE{IuBuEaHuN\"\n" +
            "              },\n" +
            "              \"start_location\": {\n" +
            "                \"lat\": 45.2083667,\n" +
            "                \"lng\": -74.3482841\n" +
            "              },\n" +
            "              \"travel_mode\": \"DRIVING\"\n" +
            "            },\n" +
            "            {\n" +
            "              \"distance\": {\n" +
            "                \"text\": \"3.4 km\",\n" +
            "                \"value\": 3359\n" +
            "              },\n" +
            "              \"duration\": {\n" +
            "                \"text\": \"3 mins\",\n" +
            "                \"value\": 159\n" +
            "              },\n" +
            "              \"end_location\": {\n" +
            "                \"lat\": 45.4851306,\n" +
            "                \"lng\": -73.58310320000001\n" +
            "              },\n" +
            "              \"html_instructions\": \"Keep <b>left</b> to continue on <b>Autoroute 720 E</b>\",\n" +
            "              \"maneuver\": \"keep-left\",\n" +
            "              \"polyline\": {\n" +
            "                \"points\": \"ojntGnzg`MaAsByBeF}@oBsD_ImBcEgA}BKSsAuCeCwFYi@]o@cAcBs@gAOUcAsAo@w@m@u@i@i@KKu@u@m@g@yAqAo@e@a@UUOyE}Bk@S?AsAg@o@Ua@MeA[_@Mw@WME_@OEAUIQG}Ag@}CaAs@WuBq@c@Oc@OaA[g@Q]MWKk@W?Ag@Uu@c@q@g@w@o@o@k@o@s@q@w@m@{@a@q@}@}AUa@aA{Ac@u@]k@yDoHiBgDwO}YGMIMcAoBe@}@o@mA\"\n" +
            "              },\n" +
            "              \"start_location\": {\n" +
            "                \"lat\": 45.4623177,\n" +
            "                \"lng\": -73.6095157\n" +
            "              },\n" +
            "              \"travel_mode\": \"DRIVING\"\n" +
            "            },\n" +
            "            {\n" +
            "              \"distance\": {\n" +
            "                \"text\": \"0.9 km\",\n" +
            "                \"value\": 882\n" +
            "              },\n" +
            "              \"duration\": {\n" +
            "                \"text\": \"1 min\",\n" +
            "                \"value\": 62\n" +
            "              },\n" +
            "              \"end_location\": {\n" +
            "                \"lat\": 45.4911521,\n" +
            "                \"lng\": -73.5774618\n" +
            "              },\n" +
            "              \"html_instructions\": \"Take exit <b>3</b> for <b>Rue Guy</b> toward <b>Montréal/Centre-Ville</b>\",\n" +
            "              \"maneuver\": \"ramp-right\",\n" +
            "              \"polyline\": {\n" +
            "                \"points\": \"ayrtGjub`MASAQCK[q@y@gBm@mAs@sAMUIOEIQ]c@}@c@w@U]SWOK_@WKEKEYKYMGCKGIEGEKIIGGIQYyDuFgA{AiAsAKIIIGEIGSKYGOAO?O?O@QDQFe@Rc@ZEFUTSV\"\n" +
            "              },\n" +
            "              \"start_location\": {\n" +
            "                \"lat\": 45.4851306,\n" +
            "                \"lng\": -73.58310320000001\n" +
            "              },\n" +
            "              \"travel_mode\": \"DRIVING\"\n" +
            "            },\n" +
            "            {\n" +
            "              \"distance\": {\n" +
            "                \"text\": \"1.4 km\",\n" +
            "                \"value\": 1424\n" +
            "              },\n" +
            "              \"duration\": {\n" +
            "                \"text\": \"3 mins\",\n" +
            "                \"value\": 158\n" +
            "              },\n" +
            "              \"end_location\": {\n" +
            "                \"lat\": 45.5018118,\n" +
            "                \"lng\": -73.56734449999999\n" +
            "              },\n" +
            "              \"html_instructions\": \"Turn <b>right</b> onto <b>René-Lévesque Blvd W</b> (signs for <b>Rue city/Montréal/Centre Ville</b>)\",\n" +
            "              \"maneuver\": \"turn-right\",\n" +
            "              \"polyline\": {\n" +
            "                \"points\": \"u~stGbra`MsBgB_B_BiC_CoDiDOOaCyBoCiCaBcB[YiCiCyCoCs@o@wAoA}BwBQQkBeBGEuCoCuBoBiAaA{CqC\"\n" +
            "              },\n" +
            "              \"start_location\": {\n" +
            "                \"lat\": 45.4911521,\n" +
            "                \"lng\": -73.5774618\n" +
            "              },\n" +
            "              \"travel_mode\": \"DRIVING\"\n" +
            "            },\n" +
            "            {\n" +
            "              \"distance\": {\n" +
            "                \"text\": \"15 m\",\n" +
            "                \"value\": 15\n" +
            "              },\n" +
            "              \"duration\": {\n" +
            "                \"text\": \"1 min\",\n" +
            "                \"value\": 9\n" +
            "              },\n" +
            "              \"end_location\": {\n" +
            "                \"lat\": 45.5017123,\n" +
            "                \"lng\": -73.5672184\n" +
            "              },\n" +
            "              \"html_instructions\": \"Turn <b>right</b> onto <b>Robert-Bourassa Blvd/Rue University</b><div style=\\\"font-size:0.9em\\\">Destination will be on the right</div>\",\n" +
            "              \"maneuver\": \"turn-right\",\n" +
            "              \"polyline\": {\n" +
            "                \"points\": \"iavtGzr_`MRW\"\n" +
            "              },\n" +
            "              \"start_location\": {\n" +
            "                \"lat\": 45.5018118,\n" +
            "                \"lng\": -73.56734449999999\n" +
            "              },\n" +
            "              \"travel_mode\": \"DRIVING\"\n" +
            "            }\n" +
            "          ],\n" +
            "          \"via_waypoint\": []\n" +
            "        }\n" +
            "      ],\n" +
            "      \"overview_polyline\": {\n" +
            "        \"points\": \"e`miGhmocNyOcAuAoKoD_k@oKqi@cNydAc^`E}~@na@{{@{E{U{Dce@mg@iEicAq_@w{@wd@wNsUi[iSgAmSfPwh@xLq{BvNepAlPsr@~D_DuGwCe}BqTciB}_AanHy^mzByWsp@_b@elDoRw{CpVqmApA}k@uXeq@qgB{eDc~BcxFot@csB{dBsiMk`@o}CdAiaAbFkwCqoBixMyPqmAm@_mAze@}aBr[c{@lAkl@uw@q}LiO}nAcl@w}Ae`@ucC_Za}HekAaqJ__EwnZmqByaO{RogEePczCmjA}uHrXwdBiKikCwk@cgC{Vsj@aCw~@}Gwr@u\\\\aw@ad@wlCtQs}DdZsrAgfAqrKkw@iaLy[k`Dya@akDoj@anB}i@sjByQ{fAef@ct@_`@qqAmWi_BiJguAeu@wbAo\\\\as@wLcsBugAmdFyq@erA{m@slCwdA{qDwIqfAiHeyCau@mfB}eBy|E}hBemFulBmqLojBwcLo~@uiDwwA}rJkGeaAdWmaBzB_dAih@}gHyiCwq^sw@iiJus@sqCwMm`BXwxA{b@iyBmEyaCeSe}EaN{oJc\\\\_cRcYumSaO_vBzaAqoDly@{oGfCmbB}Qul@or@uqC}}@a|E_d@uaAaj@{k@moAeuDem@wyIeo@qkPgk@ibDgg@seGa@gaAnJmqBam@abEwsAyuE}sA_fFAqbEie@uuDkP}y@_k@oaAyg@mvAqq@guA}w@e`Aeo@atAc|@{z@_qBel@m`CihBykBghBcwBa~Bkd@at@aV}mBpD{eAh@sm@ml@ueBwUcU{oApBog@oNoa@_h@emA{rBahAog@}]i^wu@ipB{aAi}AcwAoxB{iBkjDkwAwjBeoIytKu_AapAkXypAyY_qAsaDupFo`Ao`B_n@ss@owAo}@{~GsiMy}EalJa`DoyHayDsqMonEcrNucBucFuqAwa@gmEo|NywEegPwrAymFmf@s|C}Dcy@`Hog@`aAyhDhO{qAlCggG}EqwAaXubAca@kxAyC{_BgN}cEag@ueCi}BmlHkfFo`N_p@sgByd@eo@wfAwqCitDmsMym@}f@}jAquC{}AsmD_q@o{C_hFo`N}Ykt@u}AwnByaBsxBgx@skBemDobLywBwwGq_BagCa`@ab@ih@ksA_Q_i@}DihBum@gvCs_Aez@wYidAov@awC{p@yfDef@egFodAmuGu[mjAgHwjAxLkmGmHgy@xCeyFdEopCf]e{BwcCyiGy_@{s@{ZiPuW}I{Xg_@qh@g~@aq@gg@md@uc@\"\n" +
            "      },\n" +
            "      \"summary\": \"ON-401 E\",\n" +
            "      \"warnings\": [],\n" +
            "      \"waypoint_order\": []\n" +
            "    }\n" +
            "  ],\n" +
            "  \"status\": \"OK\"\n" +
            "}\n" +
            "\n";


   /**
     * Test that we can deserialize the above Google JSON into our class.
     */
    @Test
    @Ignore
    public void testJsonParse() throws Exception
    {
        GoogleMapDirections googleMapDirections = null;

        try
        {
            googleMapDirections = JacksonFactory.getParser().readValue(cs_googleJson, GoogleMapDirections.class);
        }
        catch (Exception ex)
        {
            org.junit.Assert.assertTrue(false);
        }
    }



}
