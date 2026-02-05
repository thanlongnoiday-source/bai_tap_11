/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package javaapplication11;

import java.util.Scanner;

abstract class NhanVien 
{ 
    private int MaNhanVien;
    private String TenNhanVien;
    abstract double TinhLuong();
    
    public int getMaNhanVien() 
    { 
        return MaNhanVien; 
    } 
    
    public void setMaNhanVien(int MaNhanVien) 
    { 
        this.MaNhanVien = MaNhanVien; 
    }
    
    public String getTenNhanVien() 
    { 
        return TenNhanVien; 
    } 
    
    public void setTenNhanVien(String TenNhanVien) 
    { 
        this.TenNhanVien = TenNhanVien; 
    }
}

class FullTime extends NhanVien
{
    private Double LuongCoBan;
    private Double HeSoLuong;
    
    public Double getLuongCoBan() 
    { 
        return LuongCoBan; 
    } 
    
    public void setLuongCoBan(Double LuongCoBan) 
    { 
        this.LuongCoBan = LuongCoBan; 
    }

    public Double getHeSoLuong() 
    { 
        return HeSoLuong; 
    } 
    public void setHeSoLuong(Double HeSoLuong) 
    { 
        this.HeSoLuong = HeSoLuong; 
    }

    @Override
    double TinhLuong() 
    {
        return LuongCoBan * HeSoLuong;
    }
}

class PartTime extends NhanVien
{
    private Double SoGioLamViec;
    private Double LuongMoiGio;
    
    public Double getSoGioLamViec() 
    { 
        return SoGioLamViec; 
    } 
    
    public void setSoGioLamViec(Double SoGioLamViec) 
    { 
        this.SoGioLamViec = SoGioLamViec; 
    }

    public Double getLuongMoiGio() 
    { 
        return LuongMoiGio; 
    } 
    
    public void setLuongMoiGio(Double LuongMoiGio) 
    { 
        this.LuongMoiGio = LuongMoiGio; 
    }
    
    @Override
    double TinhLuong() 
    {
        return SoGioLamViec * LuongMoiGio;
    }
}

public class QuanLyNhanVien 
{
    public static void main(String[] args) 
    {   
        Scanner scn = new Scanner(System.in);
        int size = 0;
        int SLNVFullTime;
        int SLNVPartTime;
        System.out.print("Nhap so luong nhan vien Full time: ");
        SLNVFullTime = scn.nextInt();
        
        System.out.print("Nhap so luong nhan vien Part time: ");
        SLNVPartTime= scn.nextInt();
        
        size = SLNVFullTime + SLNVPartTime;
        NhanVien[] danhSachNhanVien = new NhanVien[size];
        
        FullTime NVFT;
        int index= 0;
        
        System.out.println("\n===NHAP THONG TIN FULL TIME=== ");
        for (int i = 0; i < SLNVFullTime; i++)
        {
            NVFT = new FullTime();
            System.out.println("Nhan vien thu " + (i+1) + " la: ");
            
            System.out.print("Nhap ma nhan vien: ");
            int MNV = scn.nextInt();
            scn.nextLine();
            NVFT.setMaNhanVien(MNV);
            
            System.out.print("Nhap ho ten: ");
            String HTNV = scn.nextLine();            
            NVFT.setTenNhanVien(HTNV);
            
            System.out.print("Nhap luong co ban: ");
            double LCB = scn.nextDouble();
            NVFT.setLuongCoBan(LCB);
            
            System.out.print("Nhap he so luong: ");
            double HSL = scn.nextDouble();
            NVFT.setHeSoLuong(HSL);
            
            System.out.println(" ");
            danhSachNhanVien[index++] = NVFT; 
        }
        
        PartTime NVPT;
        System.out.println("\n===NHAP THONG TIN PART TIME=== ");
        for (int i = 0; i < SLNVPartTime; i++)
        {
            NVPT = new PartTime();
            System.out.println("Nhan vien thu " + (i+1) + " la: ");
            
            System.out.print("Nhap ma nhan vien: ");
            int MNV = scn.nextInt();
            scn.nextLine();
            NVPT.setMaNhanVien(MNV);
            
            System.out.print("Nhap ho ten: ");
            String HTNV = scn.nextLine();            
            NVPT.setTenNhanVien(HTNV);
            
            System.out.print("Nhap so gio lam viec: ");
            double SGLV = scn.nextDouble();
            NVPT.setSoGioLamViec(SGLV);
            
            System.out.print("Nhap luong mot gio: ");
            double LMG = scn.nextDouble();
            NVPT.setLuongMoiGio(LMG);
            
            System.out.println(" ");
            danhSachNhanVien[index++] = NVPT; 
        }
        
        System.out.println("=== BANG LUONG NHAN VIEN ===");
        for (int i = 0; i < size; i++)
        {
            NhanVien NV = (NhanVien)danhSachNhanVien[i];
            System.out.print("\nHo ten: " + NV.getTenNhanVien());
            System.out.println("");
            System.out.print("Muc luong: " + NV.TinhLuong());
            
            System.out.println("");
        }
    }
}
