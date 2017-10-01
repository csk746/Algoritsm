/**
 * Created by geonheelee on 2017. 5. 21..
 */
public class OM {
    public static void main(String[] args) {
        float min = 0.8f;
        float max = 1.2f;
        float maxNum = Long.MIN_VALUE;
        long[] value = new long[24];
        for (long a = (long) (15*min); a<=15*max; a++){
            for (long b = (long) (160*min); b<=160*max; b++){
                for (long c = (long) (120*min); c<=120*max; c++){
                    for (long d = (long) (20*min); d<20*max; d++){
                        for (long e = (long) (3*min); e <=3*max; e++){
                            for (long f = (long) (170000*min); f<=170000*max; f++){
                                for (long g = (long) (160*min); g<=160*max; g++){
                                    for (long h = (long) (12*min); h<= 12*max; h++){
                                        for (long i = (long) (200000*min); i <= 200000*max; i++){
                                            for (long j = (long) (160*min); j<=160*max; j++){
                                                for (long k = (long) (200000000*min); k<=200000000*max; k++){
                                                    for (long l = (long) (6*min); l<=6*max; l++){
                                                        for (long m = (long) (60*min); m<=60*max; m++){
                                                            for (long n = (long) (180000*min); n<=180000*min; n++){
                                                                for (long o = (long) (8000*min); o<=8000*max; o++){
                                                                    for (long p = (long) (720*min); p<=720*max; p++){
                                                                        for (long q = (long) (30*min); q<=30*max; q++){
                                                                            for (long r = (long) (1000*min); r<=1000*max; r++){
                                                                                for (long s = (long) (1000000*min); s <= 1000000*max; s++){
                                                                                    for (long t = (long) (15*min); t <= 15*max; t++){
                                                                                        for (long u = (long) (200*min); u<= 200*max; u++){
                                                                                            for (long v = (long) (15*min); v<15*max; v++){
                                                                                                for (long w = (long) (700000*min); w <= 700000*max; w++){
                                                                                                    for (long x = (long) (40000000*min); x<=40000000*max; x++){
                                                                                                        float first = getPartA(a,b,c,d);
                                                                                                        float second = getPartB(e,f,g,h,i,j);
                                                                                                        float third = getPartC(k,l,m,n,o,p,q);
                                                                                                        float forth = getPartD(r,s);
                                                                                                        float fifth = getPartE(t,u,v,w,x);
                                                                                                        float one = (1f-second/first/forth-third/forth);
                                                                                                        float two = first*forth/fifth;
                                                                                                        float ROIC = (one)*two;
                                                                                                        System.out.println("fist "+first+" second "+(long)second+" third "+(long)third+" forth "+(long)forth+" fifth "+(long)fifth);
                                                                                                        System.out.println("ROIC "+ROIC + " maxNum "+maxNum+" one "+one+" two "+two);
                                                                                                        if (ROIC > maxNum){
//                                                                                                            System.out.println(t+ " "+u +" "+v+" "+w+" "+x);
                                                                                                            maxNum = ROIC;
                                                                                                            System.out.println("흐름율 : " + (long)first +" 고정비용 : "+(long) second+" 변동비용 : "+(long)third+" 가격 : "+(long)forth+" 운영자본 : "+(long)fifth +" ROIC : " +(long)maxNum);
//                                                                                                            System.out.println("one " + one + " two "+two);
                                                                                                            System.out.println("최대값 갱신 : " + maxNum);
                                                                                                            value[0] = a;
                                                                                                            value[1] = b;
                                                                                                            value[2] = c;
                                                                                                            value[3] = d;
                                                                                                            value[4] = e;
                                                                                                            value[5] = f;
                                                                                                            value[6] = g;
                                                                                                            value[7] = h;
                                                                                                            value[8] = i;
                                                                                                            value[9] = j;
                                                                                                            value[10] = k;
                                                                                                            value[11] = l;
                                                                                                            value[12] = m;
                                                                                                            value[13] = n;
                                                                                                            value[14] = o;
                                                                                                            value[15] = p;
                                                                                                            value[16] = q;
                                                                                                            value[17] = r;
                                                                                                            value[18] = s;
                                                                                                            value[19] = t;
                                                                                                            value[20] = u;
                                                                                                            value[21] = v;
                                                                                                            value[22] = w;
                                                                                                            value[23] = x;

                                                                                                        }

                                                                                                    }
                                                                                                }
                                                                                            }
                                                                                        }
                                                                                    }
                                                                                }
                                                                            }
                                                                        }
                                                                    }
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        System.out.println("최대 ROIC "+maxNum);
        int aa = 0;
        for (long a : value){
            aa++;
            System.out.println(aa+" 번째 "+a);
        }
    }
    static float getPartA(float a, float b, float c, float d){
        float k = (c+d)*a/(a*b);
        System.out.println(k);
        return k;
    }
    static float getPartB(long a, long b, long c, long d, long e, long f){
        float k = a*b*c+d*e*f;
        return k;
    }
    static float getPartC(long a, long b, long c, long d, long e, long f, long g){
        float k = a+b*c*d+e*f*g;
        return k;
    }
    static float getPartD(long a, long b){
        float k = a*b;
        return k;
    }
    static float getPartE(long a, long b, long c, long d, long e){
        float k = a*b+c*d+e;
        return k;
    }

}
