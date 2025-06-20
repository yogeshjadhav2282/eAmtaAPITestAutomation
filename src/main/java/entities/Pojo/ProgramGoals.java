package entities.Pojo;

import java.util.List;

public class ProgramGoals {
    public static List<CarePlanPojo.ProgramGoal> getProgramGoals() {
        return List.of(
                CarePlanPojo.ProgramGoal.builder()
                        .category("bloodPressure")
                        .title("Maintain the blood pressure")
                        .trackBy("MONTH")
                        .targetType("Maintain the blood pressure")
                        .targetValue("90-120")
                        .unit("mm/hg")
                        .objective("Achieve and maintain a BMI within the healthy range (18.5 ^^– 24.9 kg/m^^²)")
                        .programGoalTasks(List.of(
                                CarePlanPojo.ProgramGoalTask.builder()
                                        .task("Monitor blood pressure once a day")
                                        .details("task details are displayed here")
                                        .build()
                        ))
                        .build(),
                CarePlanPojo.ProgramGoal.builder()
                        .category("weight")
                        .title("Maintain weight")
                        .trackBy("WEEK")
                        .targetType("measuring BMI")
                        .targetValue("18.5 - 24.9")
                        .unit("kg/m2")
                        .objective("Achieve and maintain a BMI within the healthy range (18.5 ^^– 24.9 kg/m^^²)")
                        .programGoalTasks(List.of(
                                CarePlanPojo.ProgramGoalTask.builder()
                                        .task("Aim for 30min Exercise 5 Days Per Week")
                                        .details("Engage in activities like walking, cycling, or swimming. Break into shorter sessions if needed.")
                                        .build()
                        ))
                        .build()
        );
    }
} 