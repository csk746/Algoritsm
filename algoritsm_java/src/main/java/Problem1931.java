import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by geonheelee on 2017. 7. 29..
 */
public class Problem1931 {
    public static void main(String[] args) {
        long startMS = System.currentTimeMillis();

        Scanner s = new Scanner(System.in);

        int mCount = s.nextInt();    //회의 개수
        int[] mID = new int[mCount];   //회의 번호
        int[] mStartTime = new int[mCount];  //회의 시작시간
        int[] mEndTime = new int[mCount];  //회의 종료시간
        int[] finalID = new int[mCount];  //최종 회의 번호

        //각 배열에 값 셋팅
        for(int i=0; i<mCount; i++)
        {
            mID[i] = i;
            mStartTime[i] = s.nextInt();
            mEndTime[i] = s.nextInt();
        }

//  for(int i=0; i<mCount; i++)
//  {
//   System.out.printf("%d %d %d\n", mID[i], mStartTime[i], mEndTime[i]);
//  }
//  System.out.println("======================최초 배열셋팅 완료=========================");

        //정렬을 위한 변수
        int tempIndex;
        int temp;

        for(int i=0; i<mCount; i++)
        {
            tempIndex = i;

            for(int j=i+1; j<mCount; j++)
            {
                //종료시간 배열의 뒷 값이 앞 값보다 작으면
                if(mEndTime[j] < mEndTime[tempIndex])
                    tempIndex = j;
            }

            //정렬시작
            if(tempIndex != i)
            {
                temp = mID[tempIndex];
                mID[tempIndex] = mID[i];
                mID[i] = temp;

                temp = mStartTime[tempIndex];
                mStartTime[tempIndex] = mStartTime[i];
                mStartTime[i] = temp;

                temp = mEndTime[tempIndex];
                mEndTime[tempIndex] = mEndTime[i];
                mEndTime[i] = temp;
            }
        }

//  for(int i=0; i<mCount; i++)
//  {
//   System.out.printf("%d %d %d\n", mID[i], mStartTime[i], mEndTime[i]);
//  }
//  System.out.println("=======================정렬 완료==================================");

        int finalEndTime = mEndTime[0]; //첫 회의종료시간은 최종정렬의 첫 값
        finalID[0] = mID[0];   //끝시간 순으로 정렬되었으므로 최종 회의 번호의 첫 회의번호는 첫mID
        int finalIdIndex = 1;   //finalID배열의 index, 첫 값은 정해져 있으므로 1부터 시작
        int resultCnt = 1;    //한 개 회의는 첫 값으로 정해져 있으므로 1부터 시작

        for(int i=0; i<mCount; i++)
        {
            if(mStartTime[i] >= finalEndTime)
            {
                resultCnt++;
                finalID[finalIdIndex] = mID[i];
                finalEndTime = mEndTime[i];
                finalIdIndex++;
            }
        }

//        pw.println(resultCnt);
        System.out.println(resultCnt);
//        for(int i=0; i<resultCnt; i++)
//        {
//            pw.printf("%d ", finalID[i]);
//        }

//        s.close();
//        pw.close();
//
//        long endMS = System.currentTimeMillis();
//        System.out.printf("%,d msec", endMS - startMS);


    }
}
