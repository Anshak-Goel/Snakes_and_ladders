package com.example.snakes_and_ladders;

public class UpdatingData {

    private int final_cord = 0;

    UpdatingData(int val){
        if(val==2)
        {
            final_cord=38;
        }
        else if(val==7)
        {
            final_cord=14;
        }
        else if(val==8)
        {
            final_cord=31;
        }
        else if(val==15)
        {
            final_cord=26;
        }
        else if(val==16)
        {
            final_cord=6;
        }
        else if(val==28)
        {
            final_cord=84;
        }
        else if(val==36)
        {
            final_cord=44;
        }
        else if(val==46)
        {
            final_cord=25;
        }
        else if(val==49)
        {
            final_cord=11;
        }
        else if(val==51)
        {
            final_cord=67;
        }
        else if(val==62)
        {
            final_cord=19;
        }
        else if(val==64)
        {
            final_cord=60;
        }
        else if(val==71)
        {
            final_cord=91;
        }
        else if(val==74)
        {
            final_cord=53;
        }
        else if(val==78)
        {
            final_cord=98;
        }
        else if(val==87)
        {
            final_cord=94;
        }
        else if(val==92)
        {
            final_cord=88;
        }
        else if(val==95)
        {
            final_cord=75;
        }
        else if(val==99)
        {
            final_cord=80;
        }
        else if(val==21)
        {
            final_cord=42;
        }else{
            System.out.println("Some error has occured in function update_data(), should'nt be in else ");
        }
    }
    public int getFinal_cord(){
        return final_cord;
    }
}
