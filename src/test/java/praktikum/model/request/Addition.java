package praktikum.model.request;

public class Addition {
    private String additional_Info;
    private int additional_Number;

    public Addition(){
    }

    public Addition(String additional_Info, int additional_Number) {
        this.additional_Info = additional_Info;
        this.additional_Number = additional_Number;
    }

    public String getAdditional_Info() {
        return additional_Info;
    }

    public void setAdditional_Info(String additional_Info) {
        this.additional_Info = additional_Info;
    }

    public int getAdditional_Number() {
        return additional_Number;
    }

    public void setAdditional_Number(int additional_Number) {
        this.additional_Number = additional_Number;
    }

}
