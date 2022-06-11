package Application.threads;

import lombok.Getter;

@Getter
public class Counter {
    private  int i=0;
    public void increment(){
        i++;
    }
}
