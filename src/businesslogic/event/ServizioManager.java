package businesslogic.event;

import java.util.ArrayList;

public class ServizioManager {
    ArrayList<ServiceInfo> s;
    
    
    public ServizioManager(ArrayList<ServiceInfo> s1){
        s=s1;
    }
    
    public ServiceInfo selectServizio(int id){
        ServiceInfo temp = null;
        boolean found=false;
        int i=0;
        while(found==false&&s.size()!=0&&i<s.size()){
            temp=s.get(i);
            if(temp.getId()==id)
                found=true;
        }
        return temp;
    }
}
