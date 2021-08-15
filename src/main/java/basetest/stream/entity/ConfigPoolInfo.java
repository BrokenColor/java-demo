package basetest.stream.entity;

import lombok.Data;

@Data
public class ConfigPoolInfo {

    String templateId;
    String displayName;
    String logo;
    Integer pool;
    Long task;   //所有任务
    Long queue;  //队列中的，即等待审核的任务数量
    String country;
    String lang;
    Boolean isReview; // 是否是复审。
    Boolean isExcel; // 是否是 Excel 审核。
    String label;//一级labelId

    Long auditing;  //正在审核的任务数量
}
