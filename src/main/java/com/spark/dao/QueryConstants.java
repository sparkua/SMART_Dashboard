package com.spark.dao;

/**
 * Created by Spark on 4/28/16.
 */
public class QueryConstants {

    public static String GET_DATAMART_STAT =
            "SELECT JOBRUN_LOG_ID, JOB_START_DT JOBSTARTDT, JOB_END_DT JOBENDDT, " +
                    "JOB_END_DT - JOB_START_DT JOB_DURE_TIME, " +
                    "STEPNAME, " +
                    "DECODE(JOBSTATUS,'END',SUBSTR(JOB_DURE_TIME,1,11),'END WITH ERROR','END WITH ERROR') durationTimeStatus, " +
                    "JOB_DURE_TIME durationTime, " +
                    "((SUBSTR(JOB_DURE_TIME,1,2)*60+SUBSTR(JOB_DURE_TIME,4,2))*60+SUBSTR(JOB_DURE_TIME,7,2))*1000+SUBSTR(JOB_DURE_TIME,10,6) durationTimeMS " +
                    "                    FROM " +
                    "                      (SELECT " +
                    "                        max(JL.JOBRUN_LOG_ID) over (PARTITION BY JL.PROCNAME, JL.JOBNAME,JL.STEPNAME ORDER BY JL.JOBRUN_DT) JOBRUN_LOG_ID," +
                    "                           JL.PROCNAME, JL.JOBNAME, JL.STEPNAME, JL.JOBSTATUS, " +
                    "                        TRUNC(JL.JOBRUN_DT) AS JOBRUN_DATE, " +
                    "                        JL.JOBRUN_DT AS JOB_END_DT, " +
                    "                        LAG(JL.JOBRUN_DT, 1) OVER (PARTITION BY JL.PROCNAME, JL.JOBNAME,JL.STEPNAME ORDER BY JL.JOBRUN_DT) AS JOB_START_DT, " +
                    "                        SUBSTR(TO_CHAR(JL.JOBRUN_DT - LAG(JL.JOBRUN_DT, 1) OVER (PARTITION BY JL.PROCNAME, JL.JOBNAME,JL.STEPNAME ORDER BY JL.JOBRUN_DT),'HH24:MI:SS'),12) AS JOB_DURE_TIME" +
                    "                      FROM  DMTCLMGR.JOBRUN_LOG JL " +
                    "                      WHERE TRUNC(JOBRUN_DT) >= TRUNC(SYSDATE) - ?) " +
                    "                    WHERE JOBSTATUS <> 'START' " +
                    "                      AND STEPNAME LIKE 'PROC%' " +
                    "                    GROUP BY JOBRUN_LOG_ID, JOBRUN_DATE,JOB_START_DT,JOB_END_DT,STEPNAME,JOB_DURE_TIME,DECODE(JOBSTATUS,'END',SUBSTR(JOB_DURE_TIME,1,11),'END WITH ERROR','END WITH ERROR') " +
                    "                    order by JOB_START_DT desc";

    public static String GET_DATAMART_STAT_2 =
            "SELECT stepname, jobrun_dt " +
                    "                FROM  JOBRUN_LOG " +
                    "                  WHERE JOBRUN_LOG_ID > 772887";

    public static String GET_DATAMART_PROC_LIST =
            "SELECT distinct procname PROCNAME "+
                "FROM DMTCLMGR.JOBRUN_LOG "+
                "WHERE TRUNC(JOBRUN_DT) >= TRUNC(SYSDATE) - 30";
}
