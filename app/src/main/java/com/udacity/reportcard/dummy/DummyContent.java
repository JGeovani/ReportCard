package com.udacity.reportcard.dummy;

import com.udacity.reportcard.R;
import com.udacity.reportcard.model.ReportCard;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;


/**
 * Helper class for providing sample content for user interfaces created by
 * Android template wizards.
 * <p>
 * TODO: Replace all uses of this class before publishing your app.
 */
public class DummyContent {

    /**
     * An array of sample (dummy) items.
     */
    public static final List<ReportCard> ITEMS = new ArrayList<>();

    /**
     * A map of sample (dummy) items, by ID.
     */
    public static final Map<String, ReportCard> ITEM_MAP = new HashMap<>();

    private static String[] nanodegree = new String[] {
            "Data Analyst",
            "Front-end",
            "Android Basic",
            "Android Developer",
            "Machine Learning",
            "Full Stack",
            "iOS Developer",
            "Predictive Analytics for Business",
            "Virtual Reality"
    };
    private static int[] iconNano = new int[] { R.mipmap.ic_launcher, };
    private static String[] grade = new String[] {"A", "B", "C", "D", "F"};

    static {
        for (int i = 0; i < nanodegree.length; i++) {
            addItem(createReportCard(i));
        }
    }


    private static void addItem(ReportCard item) {
        ITEMS.add(item);
        ITEM_MAP.put(item.id, item);
    }

    private static ReportCard createReportCard(int position) {
        return
            new ReportCard(
                String.valueOf(position),
                iconNano[0],
                grade[getRandom(position)],
                nanodegree[position],
                makeDetails(position)
            );
    }


    /**
     * @param position != 0
     * @return [0, 4]
     */
    private static int getRandom(int position) {
        Random random = new Random();
        int s = position % grade.length;
        int number;
        if (s > 0) {
            number = random.nextInt(s);
        } else {
            number = 0;
        }
        return number;
    }


    private static String makeDetails(int position) {
        StringBuilder builder = new StringBuilder();
        builder.append("Details about ").append(nanodegree[position]);
        builder.append("\nMore details information here.");
        return builder.toString();
    }


}
