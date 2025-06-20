package entities.Pojo;

import java.util.List;

public class VitalRange {
    // --- VITAL REFERENCES SETUP ---

    public static List<CarePlanPojo.VitalReference> getVitalRanges() { // Blood Pressure vital ranges
        List<CarePlanPojo.VitalRange> bpRanges = List.of(
                CarePlanPojo.VitalRange.builder().rangeType("LOW_MODERATE_SYSTOLIC").min(91).max(100).build(),
                CarePlanPojo.VitalRange.builder().rangeType("HIGH_MODERATE_SYSTOLIC").min(131).max(140).build(),
                CarePlanPojo.VitalRange.builder().rangeType("LOW_MODERATE_DIASTOLIC").min(61).max(80).build(),
                CarePlanPojo.VitalRange.builder().rangeType("HIGH_MODERATE_DIASTOLIC").min(81).max(90).build(),
                CarePlanPojo.VitalRange.builder().rangeType("CRITICAL_SYSTOLIC").min(141).max(180).build(),
                CarePlanPojo.VitalRange.builder().rangeType("CRITICAL_DIASTOLIC").min(91).max(120).build(),
                CarePlanPojo.VitalRange.builder().rangeType("NORMAL_SYSTOLIC").min(101).max(130).build(),
                CarePlanPojo.VitalRange.builder().rangeType("NORMAL_DIASTOLIC").min(61).max(80).build()
        );
        CarePlanPojo.VitalReference bloodPressure = CarePlanPojo.VitalReference.builder()
                .vitalType("Blood Pressure")
                .vitalRanges(bpRanges)
                .build();

        // Heart Rate vital ranges
        List<CarePlanPojo.VitalRange> hrRanges = List.of(
                CarePlanPojo.VitalRange.builder().rangeType("LOW_MODERATE").min(41).max(60).build(),
                CarePlanPojo.VitalRange.builder().rangeType("HIGH_MODERATE").min(91).max(110).build(),
                CarePlanPojo.VitalRange.builder().rangeType("CRITICAL").min(111).max(180).build(),
                CarePlanPojo.VitalRange.builder().rangeType("NORMAL").min(61).max(90).build()
        );
        CarePlanPojo.VitalReference heartRate = CarePlanPojo.VitalReference.builder()
                .vitalType("Heart Rate")
                .vitalRanges(hrRanges)
                .build();

        // Weight vital ranges
        List<CarePlanPojo.VitalRange> weightRanges = List.of(
                CarePlanPojo.VitalRange.builder().rangeType("NORMAL").min(18.5).max(24.9).build()
        );
        CarePlanPojo.VitalReference weight = CarePlanPojo.VitalReference.builder()
                .vitalType("Weight")
                .vitalRanges(weightRanges)
                .build();

        List<CarePlanPojo.VitalReference> vitalReferences = List.of(bloodPressure, heartRate, weight);

        // --- END VITAL REFERENCES SETUP ---
        return vitalReferences;
    }
}
