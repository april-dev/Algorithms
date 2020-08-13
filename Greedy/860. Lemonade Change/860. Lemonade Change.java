/**
why Greedy works

When the customer gives us $20, we have two options:

To give three $5 in return
To give one $5 and one $10.
On insight is that the second option (if possible) is always better than the first one.
Because two $5 in hand is always better than one $10

*/

public boolean lemonadeChange(int[] bills) {
        int five = 0, ten = 0;
        for(int bill:bills){
            if (bill==5){
                five++;
            }else if (bill==10){             
                five--;
                ten++;
            }else if (bill==20){
                if (ten>0){              
                    ten--;
                    five--;
                }else{
                    five-=3;
                }           
            }
            if (five<0) return false;
        }
        return true;
    }
