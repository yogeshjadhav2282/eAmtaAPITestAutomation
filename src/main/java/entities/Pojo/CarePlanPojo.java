package entities.Pojo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CarePlanPojo {
    private String title;
    private int duration;
    private String durationUnit;
    private String overview;
    private String gender;
    private String ageCriteria;
    private String age;
    private List<String> diagnosisCodes;
    private List<String> deviceName;
    private List<VitalReference> vitalReferences;
    private List<ProgramGoal> programGoals;
    private String protocolType;

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    @Builder
    public static class VitalReference {
        private String vitalType;
        private List<VitalRange> vitalRanges;
        
    }

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    @Builder
    public static class VitalRange  {
        private String rangeType;
        private double min;
        private double max;
    }

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    @Builder
    public static class ProgramGoal {
        private String category;
        private String title;
        private String trackBy;
        private String targetType;
        private String targetValue;
        private String unit;
        private String objective;
        private List<ProgramGoalTask> programGoalTasks;
    }

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    @Builder
    public static class ProgramGoalTask {
        private String task;
        private String details;
    }
}
