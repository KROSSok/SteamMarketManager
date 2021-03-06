package com.company;

public class ThreadRunner implements Runnable {

    private static final long TIME_INTERVAL = 60000;

   public static void ThreadRunner() throws Exception{
        JsonDataParser parser = new JsonDataParser("steamUrl.json");
        CSVModelDataWriter.writeDataFromURLToCSV(
                JsonDataParser.getDataByKey(
                        URLDataWriter.getDataFromURL(
                                parser.getStringObject("url"))), "steamData.csv");
    }

    @Override
    public void run() {
        Runnable runnable = () -> {
            while (true) {
                try {
                    //ThreadRunner.ThreadRunner();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                try {
                    Thread.sleep(TIME_INTERVAL);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };
        Thread thread = new Thread(runnable);
        thread.start();
    }
}
