/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package skip_list_1005105;

import java.util.Random;

/**
 *
 * @author soneya
 */
public class Skip_list_1005105 {

    
    
  int number;
  int height;
  Skip_list_item header;
  Skip_list_item tail;
  public Random toss;

  public Skip_list_1005105()  // initializing list;
  {
      
      toss= new Random();
      header = new Skip_list_item(Skip_list_item.min);
      tail = new Skip_list_item(Skip_list_item.max);
      
      header._right=tail;
      tail._left=header;
      height=0;
      number=0;
 
      
   
  }
  
  
  public void skip_add_empty_layer()
  {
       
            Skip_list_item new1, new2;

            new1 = new Skip_list_item(Skip_list_item.min);        
            new2 = new Skip_list_item(Skip_list_item.max);

            new1._right = new2;
            new1._down  = header;

            new2._left = new1;
            new2._down = tail;

            header._up = new1;
            tail._up = new2;

            header = new1;
            tail = new2;
           
            height = height + 1;     
  }
   
  public void skip_insert(int item)
  {
      
      int level=0;
      int width=1;
      Skip_list_item _new =new Skip_list_item(item);
      Skip_list_item _small= find_element(item);
      _new.right_link=1;
      
     _new._left=_small;
     _new._right=_small._right;
     _small._right._left=_new;
     _small._right=_new;
     
     while (toss.nextDouble()<.5)
     {
         if(level>=height)
         {
             skip_add_empty_layer();
         }
         
         while(_small._up==null)
         {
            
             _small=_small._left;
             width++;
            
             
         }
        
         _small=_small._up;
       
  //..................................................................       
         
         Skip_list_item new2=new Skip_list_item(item);
         new2._right=_small._right;
         _small._right._left=new2;
         _small._right=new2;
         new2._left=_small;
         
         new2._down=_new;
         _new._up=new2;
     //.............................................................................
         
         _small.right_link++;
         new2.right_link=_small.right_link-width;
         _small.right_link=width;
         
         
         
 //......................................
         _new=new2;
         level++;  
         
     }
       while(_small!=null)
        {
            while(_small!=header && _small._up==null) {
                _small=_small._left;
            }
 
            _small= _small._up;
            if(_small!=null)
                _small.right_link++;
              
        }
      number++;
      
      
  }
  
  
 
  public Skip_list_item find_element(int k)
  {
     Skip_list_item Small_Or_Eq;
     Small_Or_Eq = header;

     while ( true )
     {
                  
        while( (Small_Or_Eq._right.val) != Skip_list_item.max && (Small_Or_Eq._right.val) <= k )
        {
           Small_Or_Eq = Small_Or_Eq._right;        
        }

      
        if ( Small_Or_Eq._down != null )
        {  
           Small_Or_Eq = Small_Or_Eq._down;        
        }
        else
	{
           break;       
        }
     }

     return(Small_Or_Eq);        
  }
      
  
  public int indexOf(int k)
  {
     Skip_list_item Small_Or_Eq;
     Small_Or_Eq = header;
     int index=0;

     while ( true )
     {
                  
        while( (Small_Or_Eq._right.val) != Skip_list_item.max && (Small_Or_Eq._right.val) <= k )
        {
           index=index+Small_Or_Eq.right_link;
           Small_Or_Eq = Small_Or_Eq._right;   
          
        }
        if ( Small_Or_Eq._down != null )
        {  
           Small_Or_Eq = Small_Or_Eq._down;        
        }
        else
	{
           break;       
        }
     }

     return(index);        
  }
    
  
   public int skip_list_indexOf(int key)
  {
     Skip_list_item pos;
     int index = 0;
     int position = -1;
     pos=header;
     
     while(pos._down!=null)
     {
         pos=pos._down;
     }
     
     while( (pos._right.val!= Skip_list_item.max) && (pos._right.val!=key) )
     {
      
        index++;
        pos=pos._right;
     }
 
     if(pos._right.val==key)
     {
            position=index;
     }
     return(position);
      
  }
   
   void print_list()
   {
       
       
     Skip_list_item pos,pos1;
   
     pos=header;
     
     while(pos._down!=null)
     {
         pos=pos._down;
     }
     
     int size=number+2;
     while(size>0)
     {
        pos1=pos._right;
        
        while(pos!=null)
        {
           //System.out.print(pos.val+","+pos.right_link+"       ");
            
           System.out.print(pos.val+"       ");
           pos=pos._up;
        }
        System.out.println();
        System.out.println();
        
        
        
        pos=pos1;
        size--;
        
    }
   
       
   }
   

   
    public static void main(String[] args) 
    {
       Skip_list_1005105 instance =new Skip_list_1005105();
       
       instance.skip_insert(10);
       instance.skip_insert(20);
       instance.skip_insert(2);
       instance.skip_insert(22);
       instance.skip_insert(12);
       instance.skip_insert(27);
       instance.skip_insert(1);
       instance.skip_add_empty_layer();
       System.out.println(instance.indexOf(1));
       System.out.println(instance.indexOf(27));
       instance.print_list();
      
       
    }
}


