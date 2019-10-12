/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package skip_list_1005105;

/**
 *
 * @author soneya
 */
class Skip_list_item
{
    
    int val;
    int index;
    
  
    int right_link;
    Skip_list_item _up,_down,_left,_right;
    
   
  
  public static int min= Integer.MIN_VALUE;
  public static int max=Integer.MAX_VALUE;
    
  public Skip_list_item(int i) 
  { 
     
     val = i;
     _up = _down = _left = _right = null;
     
  }
  
  
  
    
}