package science.apolline.ioio;

public class IOIOData {
    private int count;
    private int[] buff = new int[64];

    private int PM01Value = 0;          //define PM1.0 value of the air detector module
    private int PM2_5Value = 0;         //define PM2.5 value of the air detector module
    private int PM10Value = 0;         //define PM10 value of the air detector module
    private int PM0_3Above = 0;
    private int PM0_5Above = 0;
    private int PM1Above = 0;
    private int PM2_5Above = 0;
    private int PM5Above = 0;
    private int PM10Above = 0;

    private float tempKelvin = 0;
    private float RH = 0;
    private double RHT = 0;

    final byte LENG = 31;

    public boolean checkValue() {
        boolean receiveflag = false;
        int receiveSum = 0;

        for (int i = 0; i < (LENG - 2); i++) {
            receiveSum = receiveSum + buff[i];
        }
        receiveSum = receiveSum + 0x42;

        if (receiveSum == ((buff[LENG - 2] << 8) + buff[LENG - 1])) //check the serial data
        {
            receiveflag = true;
        }
        return receiveflag;
    }
    
    public void parse(){
        PM01Value = ((buff[3] << 8) + buff[4]);
        PM2_5Value = ((buff[5] << 8) + buff[6]);
        PM10Value = ((buff[7] << 8) + buff[8]);
        PM0_3Above = ((buff[15] << 8) + buff[16]);
        PM0_5Above = ((buff[17] << 8) + buff[18]);
        PM1Above = ((buff[19] << 8) + buff[20]);
        PM2_5Above = ((buff[21] << 8) + buff[22]);
        PM5Above = ((buff[23] << 8) + buff[24]);
        PM10Above = ((buff[25] << 8) + buff[26]);
    }


    public float getTempCelcius(){
        return tempKelvin - 273.15f;
    }
    
////////////////////////////////////////////////////////////////////////////////////////////////////


    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int[] getBuff() {
        return buff;
    }
    
    public void setBuff(int position,int value) {
        this.buff[position]=value;
    }

    public int getPM01Value() {
        return PM01Value;
    }

    public void setPM01Value(int PM01Value) {
        this.PM01Value = PM01Value;
    }

    public int getPM2_5Value() {
        return PM2_5Value;
    }

    public void setPM2_5Value(int PM2_5Value) {
        this.PM2_5Value = PM2_5Value;
    }

    public int getPM10Value() {
        return PM10Value;
    }

    public void setPM10Value(int PM10Value) {
        this.PM10Value = PM10Value;
    }

    public int getPM0_3Above() {
        return PM0_3Above;
    }

    public void setPM0_3Above(int PM0_3Above) {
        this.PM0_3Above = PM0_3Above;
    }

    public int getPM0_5Above() {
        return PM0_5Above;
    }

    public void setPM0_5Above(int PM0_5Above) {
        this.PM0_5Above = PM0_5Above;
    }

    public int getPM1Above() {
        return PM1Above;
    }

    public void setPM1Above(int PM1Above) {
        this.PM1Above = PM1Above;
    }

    public int getPM2_5Above() {
        return PM2_5Above;
    }

    public void setPM2_5Above(int PM2_5Above) {
        this.PM2_5Above = PM2_5Above;
    }

    public int getPM5Above() {
        return PM5Above;
    }

    public void setPM5Above(int PM5Above) {
        this.PM5Above = PM5Above;
    }

    public int getPM10Above() {
        return PM10Above;
    }

    public void setPM10Above(int PM10Above) {
        this.PM10Above = PM10Above;
    }

    public float getTempKelvin() {
        return tempKelvin;
    }

    public void setTempKelvin(float tempKelvin) {
        this.tempKelvin = tempKelvin;
    }

    public float getRH() {
        return RH;
    }

    public void setRH(float RH) {
        this.RH = RH;
    }

    public double getRHT() {
        return RHT;
    }

    public void setRHT(double RHT) {
        this.RHT = RHT;
    }
}