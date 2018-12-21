package com.stacysiz.helpers;

import com.stacysiz.utils.ApplicationManager;

public class CalculusHelper extends HelperBase {
    public CalculusHelper(ApplicationManager manager) {
        super(manager);
    }

    public int makeSum(int a, int b) throws InterruptedException {
        if ((a >= 0 || a <= 9) && (b >= 0 || b <= 9)) {
            applicationManager.getAutoItX().controlClick("Калькулятор", "", "13" + a);
            Thread.sleep(1000);
            applicationManager.getAutoItX().controlClick("Калькулятор", "", "93");
            applicationManager.getAutoItX().controlClick("Калькулятор", "", "13" + b);
            Thread.sleep(1000);
            makeSubmit();
            Thread.sleep(1000);
            String text = applicationManager.getAutoItX().winGetText("Калькулятор", "").trim();
            Thread.sleep(3000);
            return Integer.valueOf(text);
        } else return 0;
    }

    public int makeSubtraction(int a, int b) throws InterruptedException {
        if ((a >= 0 || a <= 9) && (b >= 0 || b <= 9)) {
            insertSigleValue(a);
            Thread.sleep(3000);
            applicationManager.getAutoItX().controlClick("Калькулятор", "", "94");
            insertSigleValue(b);
            Thread.sleep(1000);
            makeSubmit();
            Thread.sleep(1000);
            String result = getResult();
            Thread.sleep(3000);
            return Integer.valueOf(result);
        } else return 0;
    }

    public int makeDeleteValueCheck(int a,int b,int c) throws InterruptedException {
        insertSigleValue(a);
        insertSigleValue(b);
        insertSigleValue(c);
        Thread.sleep(1000);
        deleteSingleValue();
        String result = getResult();
        Thread.sleep(3000);
        return Integer.valueOf(result);
    }

    public void insertSigleValue(int a) {
        if (a >= 0 || a <= 9) {
            applicationManager.getAutoItX().controlClick("Калькулятор", "", "13" + a);
        }
    }

    public void deleteSingleValue() {
        applicationManager.getAutoItX().controlClick("Калькулятор", "", "83");
    }

    public void makeSubmit() {
        applicationManager.getAutoItX().controlClick("Калькулятор", "", "121");
    }

    public String getResult(){
        return applicationManager.getAutoItX().winGetText("Калькулятор", "").trim();
    }
}
