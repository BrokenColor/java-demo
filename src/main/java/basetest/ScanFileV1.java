package basetest;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.annotation.ExcelProperty;
import lombok.Data;
import org.apache.commons.compress.utils.Sets;
import org.apache.commons.lang3.StringUtils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class ScanFileV1 {

    public static List<String[]> clasFileNames = new ArrayList();

    private static String DEFUALT_CLASSIFICATION = "Service";

    private static Map<String, String> mapContain = new HashMap<>();
    /**
     * 扫描的目录
     */
    private static final String directoryPath = "/Users/bailongma/work/IdeaWorkSpace";
    /**
     * 产生excel 目录
     */
    private static final String excelpath = "/Users/bailongma/Desktop/cannncarTypeMOdel.xlsx";
    /**
     * 关键字
     */
    //  private static  Set<String> targetString = Sets.newHashSet("channelCarTypeSwitch","ThirdChannelOpenLevel.MODEL_NAME");
 /*   private static Set<String> targetString = Sets.newHashSet("com.yueyue.user.enums.BizTypeEnum",
            "BizTypeEnum",
            "BIZ_TYPE_EXPRESS",
            "BIZ_TYPE_PREMIER",
            "bizType",
            "setBizType","SPECIAL_BIZ_TYPE","FAST_BIZ_TYPE","DriverBizTypeEnum","BIZ_TYPE"," operations"," operation","businessType","bizTypeNames","bizTypeName");
*/
    private static Set<String> targetString = Sets.newHashSet("com.yueyue.user.enums.BizTypeEnum", "BizTypeEnum",
            "BIZ_TYPE_EXPRESS", "BIZ_TYPE_PREMIER", "bizType", "setBizType", "SPECIAL_BIZ_TYPE", "FAST_BIZ_TYPE",
            "DriverBizTypeEnum", "BIZ_TYPE", " operations", " operation", "businessType", "bizTypeNames", "bizTypeName",
            "DriverImportParam", "ImportParam", "FixedPriceConfigSyncParam", "PushXParam", "ConfigBizParam",
            "ConfigCenterParam", "OrderQualificationsParam", "PushXParam", "DriverChainOrderConfigParam",
            "RecruitNotOpenCityExportParam", "FixedPriceCityConfigQueryParam", "FixedPriceCityConfigUpdateParam",
            "HomePageStatConfigDetailParam", "MessagePushParam", "BaseParam", "CommonQuestionParam", "AppCarQueryParam",
            "AppCountOrderNumParam", "FaceIdExpiredParam", "FaceIdInnerParam", "HomoModelParam", "DriverRequestParam",
            "PushXParam", "AssetsCollectionCarAuditParam", "AssetsCollectionRejectReasonParam", "AuditCompleteParam",
            "CarCollectionConfigParam", "CarCollectionCustomParam", "CarCollectionJobParam", "CarCollectionTaskParam",
            "CommitAuditInfoParam", "OcrConfigParam", "RecruitActivityDetailParam", "RecruitAuditCommitParam",
            "RecruitAuthParam", "RecruitRecommendParam", "RecruitTemplateParam", "UnionBannerParam",
            "AssetsRecruitInfoParam", "AssetsRecruitRuleParam", "AssetsRecruitSaveOrUpdateParam", "PushXParam",
            "ConfigBizParam", "RecruitRuleInitParam", "ChangeCarBizTypeParam", "ConfigCenterParam", "PushXParam",
            "PushXParam", "DriverCruiseAbilityStateParam", "DriverInfoAdminParam", "DriverInitSpectacularParam",
            "DriverParam", "DriverSpectacularParam", "DriverStandardParam", "DriverStateParam", "OpenCityInitParam",
            "UserNucleicLastAuditParam", "CruiseDriverStateExtParam", "CruiseDriverStateParam",
            "CruiseOperationAreaParam", "DriverRankConfigParam", "OpenDriverParam", "DriverBaseParam",
            "DriverStateParam", "DriverImportParam", "BaseParam", "DriverParam", "AdditionalRecordingParam",
            "AssetsCruiseCarInfoParam", "AssetsMigrationInformationParam", "AuditCarModelLevelParam",
            "AuditCarModelMainParam", "AuditCruiseModelRuleParam", "BatchPartTransportCompanyParam",
            "BatchTransportCompanyV2Param", "BindCarTypeParam", "CompanyParam", "ComplianceScoreStateSyncParam",
            "DriverAuditParam", "H5CompanyParam", "ModelLevelParam", "RecruitDataParam", "RecruitDataParamV2",
            "TransportCompanyParam", "TransportCompanyPriorParam", "TransportCompanyQueryParam",
            "TransportRecruitCompanyParam", "ConfigBizParam", "ConfigCenterParam", "PushXParam",
            "AdminRecordingAuditParam", "AdminBatchDriverCarParam", "AdminBatchOperationParam",
            "AdminBatchOperationQueryParam", "AdminCarCheckParam", "AdminCarParam",
            "AdminCertificatesExpireStatusQueryParam", "AdminCertificatesQueryParam", "AdminCollectionCarAuditParam",
            "AdminDriverAssessParam", "AdminDriverAuditParam", "AdminDriverChangePhoneConfigQueryParam",
            "AdminDriverChangePhoneConfigUpdateParam", "AdminDriverOperateParam", "AdminDriverParam",
            "AdminDriverRankConfigParam", "AdminDriverRealPositionParam", "AdminDriverScheduleListParam",
            "AdminDriverSpectacularParam", "AdminDriverStateLogParam", "AdminFileUploadParam", "AdminHireCarListParam",
            "AdminRecruitAuditCommitParam", "AdminRecruitAuditQueryParam", "AdminReservedDriverNotifyParam",
            "AdminSetUpTransportCompanyPriorParam", "AdminStandardConfigParam", "AdminTransportCompanyInfoParam",
            "AdminTransportCompanyLineParam", "AdminTransportCompanyParam", "AdminTransportCompanyV2Param",
            "DriverQueryEsParam", "InitDefaultTransportCompanyParam", "QueryChangePhoneConfigParam",
            "TransportCompanyBizTypeV2Param", "TransportCompanyOpenBizTypeParam", "SendSmsParam", "AdminCarQueryParam",
            "AdminDriverBindCarQueryParam", "AdminDriverCarMigrationParam", "AdminDriverQueryParam",
            "AdminExpiryLicenseQueryParam", "AdminMigrationInformationParam", "AdminSupplementQueryParam",
            "AdminTransportMigrationParam", "AdminUserTagMkParam", "AdminUpgradeAuditQueryParam",
            "CreateRecruitExportTaskParam", "CreateResignExportTaskParam", "QueryTransportCompanyListParam",
            "AdminAgentCompanyParam", "FaceWhitelistAppealParam", "AdditionalRecordingAuditParam",
            "BatchTransportCompanyV2Param", "CarLevelRelTypeParam", "CompanyBizParam", "CompanyParam",
            "DriverAuditExtParam", "DriverAuditParam", "TransportCompanyParam", "BiHighQualityDriverDiParam",
            "DriverParam", "DriverRankConfigParam", "DriverRankParam", "ChangeCarAuditEsParam",
            "CollectionAuditCountEsParam", "ChangeCarAuditGeneralParam", "CollectionPendingAuditGeneralParam",
            "RecruitApproveAuditParam", "RecruitPendingAuditGeneralParam", "ChangCarLogGeneralParam",
            "UpdateCarTeamIdParam", "UpdateDriverCarTeamIdParam", " ConfigBizVO", " ConfigDto",
            " FixedPriceCityConfigDto", " OperationCityVO", " CruiseCarModelStandardVO", " SysAdminOpenCityMessageVO",
            " SyncComplianceDataDTO", " BatchDriverCarDetailLogVO", " HireDriverCarRecordVO", " DriverPlainDataDO",
            " FixedPriceCityConfigDto", " HomePageStatisticsItem", " HomePageStatConfigItem",
            " HomePageStatConfigDetailVO", " SysAdminOpenCityMessageVO", " DriveFatigueDto", " PassengerRiskDto",
            " CommonQuestionVO", " ConfigBizVO", " ConfigDto", " ConfigDtoV2", " AppBindCarInfoVO", " AppCarVO",
            " AppDriverListVO", " RecruitCheckVO", " DriverInfoAdminInnerVO", " DriverInnerVO",
            " HomePageStatisticsItem", " HomePageStatisticsPartDTO", " CarTypeV2ConfigurationVO",
            " FixedPriceCityConfigDTO", " CarPoolModelDTO", " DriverOnlineVO", " CollectionTemplateQuery",
            " AssetsRecruitInfoApiVO", " AssetsRecruitInfoVO", " AssetsRecruitInfoVO",
            " AssetsCollectionRejectReasonVO", " AssetsRecruitRuleVO", " AuditInfoVO", " CarCollectionConfigVO",
            " CarCollectionCustomVO", " CarCollectionTaskPageVO", " CarCollectionTaskVO", " ChannelCarTypeConfigVO",
            " RecruitActivityDetailVO", " RecruitAuthVO", " RecruitRecommendVO", " RecruitTemplateVO",
            " ReplacePlateCarInfoVO", " ReplacePlateNewCarInfoVO", " ReplacePlateOldCarInfoVO", " UnionBannerVO",
            " NetworkApplyGuideVO", " SysAdminOpenCityMessageVO", " ChangeCarBizTypeVO", " ConfigDto", " ConfigBizVO",
            " DriverCoreFieldVO", " OperationRuleDto", " ActivateDriverVO", " ChannelCarTypeVO", " DriverCreateInfoVo",
            " DriverHealthCodeAuditVO", " DriverInfoAdminVO", " DriverSpectacularVO", " DriverStandardVO",
            " DriverStateInfoVO", " DriverStateVO", " DriverUpdateSettingsVO", " DriverVO", " OrderVO",
            " UnfinshOrderVO", " UserNucleicLastAuditVO", " CruiseDriverOrderStateVO", " CruiseDriverStateVO",
            " OperationCityVO", " DriverAutoGrabOrderConfigVO", " DriverMeterFixPriceConfig", " DriverRankConfigVO",
            " UnionDriverTenantVO", " OpenDriverVO", " DriverEsPeggingVO", " RegulatoryDriverBaseVO",
            " RegulatoryDriverInfoVO", " DriverSpecificVO", " DriverStateSpecificVO", " DriverInfoVO", " CarrierVO",
            " DriverVO", " DriverOnlineVO", " BatchDriverCarDetailLogVO", " DriverInfoAdminArguments", " UserVO",
            " DriverBaseVO", " DriverWithCardNoVO", " DriverWithTypeVO", " AssetsAdditionalRecordingAuditVO",
            " AssetsDriverUpdateLogResponse", " AssetsMigrationInformationVO", " AuditCarModelDetailVO",
            " AuditCarModelMainVO", " CarLevelRelTypeVO", " CompanyVO", " CruiseCityCarLevelVO", " DriverAuditCheckVO",
            " DriverAuditExtVO", " DriverAuditVO", " ModelLevelVO", " PushMessageVO", " RecruitDetailVO", " TeamVO",
            " TransportCompanyVO", " CarMainInfoVO", " RegulatoryAssetsDriverInfoVO", " RegulatoryCarInfoVO",
            " SysCarAuditMainVO", " UpgradeRecordAuditVO", " TransportMigrateVO", " AdminRecordingAuditVO",
            " AdminAssetsRecruitAuditExportVO", " AdminAssetsRecruitAuditVO", " AdminAssetsTransportCompanyVO",
            " AdminCarVO", " AdminCertificatesExpireStatusExportVO", " AdminCertificatesExpireStatusVO",
            " AdminCertificatesPageEsVO", " AdminCertificatesPageVO", " AdminCollectionAuditLogPageEsVO",
            " AdminCollectionCarAuditMainVO", " AdminCollectionCarAuditVO", " AdminDriverAssessDetailDiVO",
            " AdminDriverAuditExportVO", " AdminDriverAuditVO", " AdminDriverBindCarExportVO",
            " AdminDriverCarMigrationVO", " AdminDriverInfoToExamVo", " AdminDriverListVO",
            " AdminDriverNucleicAuditVO", " AdminDriverOperateVO", " AdminDriverRankConfigVO",
            " AdminDriverScheduleListVO", " AdminDriverSpectacularVO", " AdminDriverStateVO", " AdminDriverVO",
            " AdminDriverWithCarForCcsVO", " AdminExpireCertificatesExportVO", " AdminExpiryLicenseVO",
            " AdminExportCarVo", " AdminExportCertificatesExpireDriverVO", " AdminExportCsvCarVO",
            " AdminExportDriverVo", " AdminExportVerifyCarVo", " AdminExportVerifyDriverVo", " AdminFleetDriverVO",
            " AdminFleetLogVO", " AdminHireCarRecordVo", " AdminMigrationInformationVO", " AdminReassignDriverVO",
            " AdminStandardConfigVO", " AdminSupplementAuditDetailVO", " AdminTransportCompanyVO",
            " AdminTransportMigrateDetailVO", " AssetsCollectionAuditVO", " AssetsRecruitPendingExportVO",
            " AssetsSpChangePhoneConfigVO", " AssetsUploadTaskVO", " BatchDriverCarDetailVO", " CarTypeConfigVO",
            " ChannelCarTypeVO", " DriverInFormationEs", " DriverModeSettingVO", " DriverNucleicAuditVO",
            " DriverPlainDataVO", " DriverPlainListVO", " NewCarInfoVO", " CarDetailVO", " DriverDetailVO",
            " DriverBaseInfoVO", " SystemMessageVO", " AdminAgentCompanyVO", " CarInfoVO", " DriverInfoVO",
            " FaceWhitelistAppealInfoVO", " FaceWhitelistAppealVO", " OrderVO", " CarBaseDetailVO",
            " DriverBaseDetailVO", " DriverPageVO", " AdditionalRecordingAuditVO", " CarLevelRelTypeVO", " CompanyVO",
            " DriverAuditExtVO", " DriverAuditVO", " TransportCompanyVO", " BiHighQualityDriverDiVO",
            " DriverRankConfigVO", " DriverRankVO", " CarInfoDTO", " CarLevelRelTypeDTO", " CarTeamDTO");
    /**
     * 这个字段可有可无， 这个是必填关键字，如果我只想扫描 @GatewayService 或者 rpc  job 的 ，如果没有就全部
     */
    private static String mustString = "@gatewayservice";
    /**
     * directoryPath 排出的目录
     */
    private static Set<String> excludeScanDirectoryPath = Sets.newHashSet(
            "/Users/bailongma/work/IdeaWorkSpace/caseDemo", "/Users/bailongma/work/IdeaWorkSpace/leopard-excel-hk");

    /**
     * 排出文件中包含如下目录
     */
    private static Set<String> excludeClassPath = Sets.newHashSet("src/test/", "TestController", "ControllerTest",
            "target/classes");
    /**
     * 分类, 按照关键字，我们统计出来的数据可能有 model 、 service 、
     */
    private static Set<String> modelTypeWithEnd = Sets.newHashSet("vo", "dto", "param");

    private static Set<String> doTypeWithEnd = Sets.newHashSet("do", "/dao/model/");
    private static Set<String> daoTypeWithEnd = Sets.newHashSet("dao");

    private static Set<String> enumTypWithEnd = Sets.newHashSet("enum");

    private static Set<String> utilTypWithEnd = Sets.newHashSet("util", "constant");

    private static Set<String> serviceTypWithEnd = Sets.newHashSet();

    //注意用有序的 dao，
    private static Map<String, Set<String>> CLASSIFICATION_STANDARD = new LinkedHashMap<>();

    static {
        CLASSIFICATION_STANDARD.put("Model", modelTypeWithEnd);
        CLASSIFICATION_STANDARD.put("Do", doTypeWithEnd);
        CLASSIFICATION_STANDARD.put("Dao", daoTypeWithEnd);
        CLASSIFICATION_STANDARD.put("Enum", enumTypWithEnd);
        CLASSIFICATION_STANDARD.put("Util", utilTypWithEnd);
        CLASSIFICATION_STANDARD.put(DEFUALT_CLASSIFICATION, serviceTypWithEnd);
    }

    public static void readFile(String directoryPath, int i) {
        // 创建File对象
        File directory = new File(directoryPath);

        // 检查目录是否存在并且是一个目录
        if (!directory.exists() || !directory.isDirectory()) {
            System.out.println("目录不存在或者不是一个目录");
            return;
        }

        if (excludeScanDirectoryPath.contains(directory.getAbsolutePath())) {
            //            System.err.println("不扫描的目录" + directory.getAbsoluteFile());
            return;
        }

        // 获取目录下的所有文件和子目录
        File[] files = directory.listFiles();
        if (files == null) {
            return;
        }

        for (File file : files) {
            if (file.isFile() && file.getName().contains(".java")) {
                //必填校验
                boolean mustExitst = true;
                if (StringUtils.isNotBlank(mustString)) {
                    mustExitst = fileNameContainsMustString(file.getAbsolutePath(), mustString);
                }

                if (!mustExitst) {
                    continue;
                }
                //目标匹配方法
                boolean targetExist = fileNameContainsTargetString(file.getAbsolutePath(), targetString);
                if (targetExist) {
                    String[] result = splitClass(file.getAbsolutePath());
                    boolean flag = false;
                    for (String str : excludeClassPath) {
                        flag = result[1].contains(str);
                        if (flag) {
                            break;
                        }
                    }
                    if (!flag) {
                        clasFileNames.add(result);
                    }
                    //                    clasFileNames.add(result);
                    //                    System.out.println("文件：" + result[0] + "     " + result[1] + "--------" + count++);
                    //                    System.out.println("文件：" + file.getAbsolutePath() + "----" + count++);
                }
            } else if (file.isDirectory()) {
                //              System.out.println("目录：" + file.getName());
                readFile(file.getAbsolutePath(), i++);
            }
        }
    }

    public static Boolean fileNameContainsTargetString(String filePath, Set<String> targetString) {
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                for (String targetValue : targetString) {
                    if (line.toLowerCase().contains(targetValue.toLowerCase())) {
                        mapContain.put(filePath, targetValue.toLowerCase());
                        return true;
                    }
                }
            }
        } catch (IOException e) {
            System.out.println("Error reading the file.");
            return false;
        }
        return false;
    }

    public static Boolean fileNameContainsMustString(String filePath, String mustString) {
        if (StringUtils.isBlank(mustString)) {
            return true;
        }
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                if (line.toLowerCase().contains(mustString)) {
                    return true;
                }
            }
        } catch (IOException e) {
            System.out.println("Error reading the file.");
            return false;
        }
        return false;

    }

    public static String[] splitClass(String javaClass) {
        javaClass = javaClass.substring(javaClass.indexOf("IdeaWorkSpace/") + 14);
        javaClass = javaClass.replaceFirst("/", "#");
        int index = javaClass.indexOf("/");
        String prePuf = javaClass.substring(0, index);
        String lastPuf = javaClass.substring(index + 1);
        return new String[] { prePuf, lastPuf };
    }

    public static List<String[]> sort(List<String[]> param) {
        Collections.sort(param, (v1, v2) -> {
            return v1[1].compareTo(v2[1]);
        });
        return param;
    }

    public static void clasHandleFromLocal() {

        //扫描目录
        ScanFileV1.readFile(directoryPath, 0);
        Map<String, Set<String>> map = new HashMap<>();
        // 分类分组
        for (String[] arr : ScanFileV1.clasFileNames) {
            if (!map.containsKey(arr[0])) {
                Set<String> list = new TreeSet<>();
                map.put(arr[0], list);
            }
            map.get(arr[0]).add(arr[1]);
        }
        int size = 0;
        for (Set<String> list : map.values()) {
            size += list.size();
        }
        System.out.println(size);
        Map<String, Map<String, Set<String>>> mapMap = new HashMap<>();
        for (Map.Entry<String, Set<String>> entry : map.entrySet()) {
            //初始化所有的map
            if (!mapMap.containsKey(entry.getKey())) {
                Map<String, Set<String>> map1 = new HashMap<>();
                mapMap.put(entry.getKey(), map1);
                for (String str : CLASSIFICATION_STANDARD.keySet()) {
                    Set<String> set = new TreeSet<>();
                    map1.put(str, set);
                }
            }

            for (String str : entry.getValue()) {
                boolean isMatch = false;
                for (Map.Entry<String, Set<String>> entry1 : CLASSIFICATION_STANDARD.entrySet()) {
                    for (String strMatch : entry1.getValue()) {
                        if (str.toLowerCase().contains(strMatch)) {
                            isMatch = true;
                            break;
                        }
                    }
                    if (isMatch) {
                        mapMap.get(entry.getKey()).get(entry1.getKey()).add(str);
                        break;
                    }
                }
                if (!isMatch) {
                    mapMap.get(entry.getKey()).get(DEFUALT_CLASSIFICATION).add(str);
                }
            }
        }
        // System.out.println(JsonUtils.toJson(mapMap));
        List<ExcelVo> list = new ArrayList<>();
        for (Map.Entry<String, Map<String, Set<String>>> entry : mapMap.entrySet()) {
            for (Map.Entry<String, Set<String>> entry1 : entry.getValue().entrySet()) {
                for (String str : entry1.getValue()) {
                    ExcelVo excelVo = new ExcelVo();
                    String[] arr = entry.getKey().split("#");
                    excelVo.setProjectName(arr[0]);
                    excelVo.setSubProjectName(arr[1]);
                    excelVo.setClassFiName(entry1.getKey());
                    excelVo.setPathName(str);
                    excelVo.setTableName(str.substring(str.lastIndexOf("/") + 1));
                    list.add(excelVo);
                }
            }
        }
        //写入信息
        EasyExcel.write(excelpath, ExcelVo.class).sheet("Sheet1").doWrite(list);
    }

    public static void main(String[] args) {
        clasHandleFromLocal();
    }

    /**
     * excel 实体
     */
    @Data
    static class ExcelVo {
        @ExcelProperty("项目")
        private String projectName;
        @ExcelProperty("子项目")
        private String subProjectName;
        @ExcelProperty("分类")
        private String classFiName;
        @ExcelProperty("路径")
        private String pathName;
        @ExcelProperty("表")
        private String tableName;
    }

}
