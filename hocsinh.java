
package lab3;
import java.util.Scanner;
public class hocsinh {
  private int maso;
  private String hoten;
  private float dtb;
  public int getmaso(){
      return maso;
  }
  public void setmaso(int maso){
      this.maso=maso;
  }
  public String gethoten(){
      return hoten;
  }
  public void sethoten(String hoten){
      this.hoten=hoten;
  }
  public float getdtb(){
      return dtb;
  }
  public void setdtb(float dtb){
      this.dtb=dtb;
  }
  public hocsinh(){
      this.maso=0;
      this.hoten=null;
      this.dtb=0f;
  }
  public hocsinh(int maso,String hoten,float dtb){
      this.maso=maso;
      this.hoten=hoten;
      this.dtb=dtb;
  }
  public hocsinh(hocsinh tmp){
      this.maso=tmp.maso;
      this.hoten=tmp.hoten;
      this.dtb=tmp.dtb;
  }
  public void input(){
      Scanner sc = new Scanner(System.in);
      System.out.println("Nhap ma so: ");
      maso=sc.nextInt();
      sc.nextLine();
      System.out.println("Nhap ho ten: ");
      hoten=sc.nextLine();
      System.out.println("Nhap diem trung binh: ");
      dtb=sc.nextFloat();
  }
  public void output(){
      System.out.println(maso+"-"+hoten+"-"+dtb);
  }
  public static class demo1{
      public static void main(String[]args){
          hocsinh hs1 = new hocsinh();
          hs1.input();
          hs1.output();
          hocsinh hs2 = new hocsinh(111,"nguyen hung",8.5f);
          hs2.output();
          hocsinh hs3 = new hocsinh(hs2);
          hs3.output();
          hs3.sethoten("phan chau");
          hs3.output();
          float max = hs1.getdtb();
          String ht = hs1.gethoten();
          if(max<hs2.getdtb()){
              max = hs2.getdtb();
              ht=hs2.gethoten();
          }
          if(max<hs3.getdtb()){
              max=hs3.getdtb();
              ht=hs3.gethoten();
          }
          System.out.println("hocsinh"+ht+"co dtb cao nhat la:"+max);
      }
  }
  public static class danhsach{
      private hocsinh ds[];
      private int soluong;
      public void nhapdanhsach(){
          Scanner nhapsoluong = new Scanner(System.in);
          System.out.print(" nhap so luong hoc sinh: ");
          soluong = nhapsoluong.nextInt();
          nhapsoluong.nextLine();
          ds = new hocsinh[soluong];
          for(int i = 0;i<soluong;i++){
              ds[i]=new hocsinh();
              ds[i].input();
          }
      }
      public void xuatds(){
          System.out.println("Danh sach hoc sinh la: \n");
          for(int i =0;i<soluong;i++)
              ds[i].output();
      }
      public void sapxep(){
          for(int i=0; i <soluong - 1;i++){
              for(int j = i +1;j<soluong;j++){
                  if(ds[i].getdtb()<ds[j].getdtb()){
                      hocsinh temp=ds[i];
                      ds[i]=ds[j];
                      ds[j]=temp;
                  }
              }
          }
      }
  }
  public static class demo2 {
        public static void main(String[] args) {
            danhsach dds = new danhsach();
            dds.nhapdanhsach();
            dds.sapxep();
            dds.xuatds();
        }
    }
}

