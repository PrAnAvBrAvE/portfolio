#include<stdio.h>
#include<string.h>
#include<stdlib.h>
#include<conio.h>
#include<iostream.h>
class infor
{
     public:
     void info();
     void bmw();
     void porsche();
     void ferrari();
     void mercedes();
};
void infor::info()
{      xr:
       int choice;
       clrscr();
       cout<<"\n\t\t\t***INFORMATION SECTION***\n\t\t\t\t***Menu***\n\t1. BMW\n\t2. PORSCHE\n\t3. FERRARI\n\t4. MERCEDES";
       cout<<"\n\n\tSelect car Brand no\n\t";
       cin>>choice;
       switch(choice)
       {
	      case 1:
		bmw();
		break;
	      case 2:
		porsche();
		break;
	      case 3:
		ferrari();
		break;
	      case 4:
		 mercedes();
		 break;
	      default:
		  cout<<"INVALID INPUT";
		  goto xr;
       }
}
void infor::bmw()
{
       xo:
       int choice;
       clrscr();
       cout<<"\n\t\t\t***BMW***\n\t\t\t***Menu***\n\t1. X6\n\t2. X5\n\t3. X3\n\t";
       cout<<"\n\tSelect model no\n\t";
       cin>>choice;
       switch(choice)
       {
	      case 1:
		cout<<"\n\tBrand name\tBMW\n\tModel name\tX6\n\tFuel Economy\t10 km perl\n\tSeating Capacity\t6\n\tcost\t3200000";
		break;
	      case 2:
		cout<<"\n\tBrand name\tBMW\n\tModel name\tX5\n\tFuel Economy\t9 km perl\n\tSeating Capacity\t5\n\tcost\t2700000";
		break;
	      case 3:
		cout<<"\n\tBrand name\tBMW\n\tModel name\tX3\n\tFuel Economy\t8 km perl\n\tSeating Capacity\t4\n\tcost\t2000000";
		break;
	      default:
		  cout<<"\n\tINVALID INPUT";
		  goto xo;
       }
       getch();
}
void infor::porsche()
{
       xq:
       clrscr();
       int choice;
       cout<<"\n\t\t\t***PORSCHE***\n\t\t\t***Menu***\n\t1. Panamera\n\t2. Cayman\n\t3. XT\n\t";
       cout<<"\n\tSelect model no\n\t";
       cin>>choice;
       switch(choice)
       {
	      case 1:
		cout<<"\n\tBrand name\tPorsche\n\tModel name\tPanamera\n\tFuel Economy\t13 km perl\n\tSeating Capacity\3\n\tcost\t1.27 crore";
		break;
	      case 2:
		cout<<"\n\tBrand name\tPorsche\n\tModel name\tCayman\n\tFuel Economy\t11 km perl\n\tSeating Capacity\t2\n\tcost\n\t2.66 crore";
		break;
	      case 3:
		cout<<"\n\tBrand name\tPorsche\n\tModel name\tXT\n\tFuel Economy\t9 km perl\n\tSeating Capacity\t4\n\tcost\t1.2 crore";
		break;
	      default:
		  cout<<"\n\tINVALID INPUT";
		  goto xq;
       }
       getch();
}
void infor::ferrari()
{
       xt:
       int choice;
       clrscr();
       cout<<"\n\t\t\t***FERRARI***\n\t\t\t***Menu***\n\t1. California T\n\t2. GT374\n\t3. GT474\n\t";
       cout<<"\n\tSelect car no\n\t";
       cin>>choice;
       switch(choice)
       {
	      case 1:
		cout<<"\n\tBrand name\tFerrari\n\tModel name\tCalifornia T\n\tFuel Economy\t8 km perl\n\tSeating Capacity\2\n\tcost\t5.2 crore";
		break;
	      case 2:
		cout<<"\n\tBrand name\tFerrari\n\tModel name\tGT374\n\tFuel Economy\t9 km perl\n\tSeating Capacity\t3\n\tcost\t4.7 crore";
		break;
	      case 3:
		cout<<"\n\tBrand name\tFerrari\n\tModel name\tGT474\n\tFuel Economy\t12 km perl\n\tSeating Capacity\t4\n\tcost\t5 crore";
		break;
	      default:
		  cout<<"\n\tINVALID INPUT";
		  goto xt;
       }
       getch();
}
void infor::mercedes()
{
       xo:
       int choice;
       clrscr();
       cout<<"\n\t\t\t***Mercedes***\n\t\t\t***Menu***\n\t1. A Class\n\t2. GLA Class\n\t3. C Class\n\t";
       cout<<"\n\tSelect car no\n\t";
       cin>>choice;
       switch(choice)
       {
	      case 1:
		cout<<"\n\tBrand name\tMercedes\n\tModel name\tA Class\n\tFuel Economy\t10 km perl\n\tSeating Capacity\t3\n\tcost\t2000000";
		break;
	      case 2:
		cout<<"\n\tBrand name\tMercedes\n\tModel name\tGLA Class\n\tFuel Economy\t9 km perl\n\tSeating Capacity\t5\n\tcost\t2700000";
		break;
	      case 3:
		cout<<"\n\tBrand name\tMercedes\n\tModel name\tC Class\n\tFuel Economy\t8 km perl\n\tSeating Capacity\t4\n\tcost\t2800000";
		break;
	      default:
		  cout<<"\n\tINVALID INPUT";
		  goto xo;
       }
       getch();
}
class reserve
{
    protected:
    char name[30],brand_name[30],model_name[30];
    double adhaar,pan,price;
    public:
    void reservation();
    void info1();
    void bmw1();
    void porsche1();
    void ferrari1();
    void mercedes1();
     void payment1()
       {
	clrscr();
	double a;
	cout<<"\n\t\t\t***RECEIPT***\n\n\t\t##cashback available is 2%##";
	a=(price*2)/100;
	cout<<"\n\n\tCust_Name\t"<<name<<"\n\tAdhaar ID\t"<<adhaar<<"\n\tPan no\t\t"<<pan<<"\n\tBrand_Name\t"<<brand_name<<"\n\tModel_Name\t"<<model_name<<"\n\tCashback\t"<<a;
	price=price-a;
	cout<<"\n\n\tTotal="<<price;
	getch();
       }
};
void reserve::reservation()
{
	   clrscr();
	   cout<<"\t\t***Reservation section***\n\tEnter Your Name\n\t";
	   cin>>name;
	   cout<<"\n\tEnter Adhaar ID\n\t";
	   cin>>adhaar;
	   cout<<"\n\tEnter Pan no\n\t";
	   cin>>pan;
}
void reserve::info1()
{      xra:
       int choice;
       clrscr();
       cout<<"\n\t1. BMW\n\t2. PORSCHE\n\t3. FERRARI\n\t4. MERCEDES";
       cout<<"\n\n\tSelect car Brand no\n\t";
       cin>>choice;
       switch(choice)
       {
	      case 1:
		bmw1();
		strcpy(brand_name,"BMW");
		break;
	      case 2:
		porsche1();
		strcpy(brand_name,"Porsche");
		break;
	      case 3:
		ferrari1();
		strcpy(brand_name,"Ferrari");
		break;
	      case 4:
		 mercedes1();
		 strcpy(brand_name,"Mercedes");
		 break;
	      default:
		  cout<<"INVALID INPUT";
		  goto xra;
       }
}
void reserve::bmw1()
{
       xoa:
       int choice;
       clrscr();
       cout<<"\n\t1. X6\n\t2. X5\n\t3. X3\n\t";
       cout<<"\n\tSelect model no\n\t";
       cin>>choice;
       switch(choice)
       {
	      case 1:
		price=3200000;
		strcpy(model_name,"X6");
		break;
	      case 2:
		price=2700000;
		strcpy(model_name,"X5");
		break;
	      case 3:
		price=2000000;
		strcpy(model_name,"X3");
		break;
	      default:
		  cout<<"INVALID INPUT";
		  goto xoa;
       }
}
void reserve::porsche1()
{
       xqa:
       clrscr();
       int choice;
       cout<<"\n\t1. Panamera\n\t2. Cayman\n\t3. XT\n\t";
       cout<<"\n\tSelect model no\n\t";
       cin>>choice;
       switch(choice)
       {
	      case 1:
		price=12700000;
		strcpy(model_name,"Panamera");
		break;
	      case 2:
		price=26600000;
		strcpy(model_name,"Cayman");
		break;
	      case 3:
		price=12000000;
		strcpy(model_name,"XT");
		break;
	      default:
		  cout<<"INVALID INPUT";
		  goto xqa;
       }
}
void reserve::ferrari1()
{
       xt1:
       int choice;
       clrscr();
       cout<<"\n\t1. California T\n\t2. GT374\n\t3. GT474\n\t";
       cout<<"\n\tSelect car no\n\t";
       cin>>choice;
       switch(choice)
       {
	      case 1:
	       price=52000000;
	       strcpy(model_name,"California T");
		break;
	      case 2:
		price=47000000;
		strcpy(model_name,"GT374");
		break;
	      case 3:
	       price=50000000;
	       strcpy(model_name,"GT474");
		break;
	      default:
		  cout<<"\n\tINVALID INPUT\n\t";
		  goto xt1;
       }
}
void reserve::mercedes1()
{
       xo1:
       int choice;
       clrscr();
       cout<<"\n\t1. A Class\n\t2. GLA Class\n\t3. C Class\n\t";
       cout<<"\n\tSelect car no\n\t";
       cin>>choice;
       switch(choice)
       {
	      case 1:
	       price=2000000;
	       strcpy(model_name,"A Class");
		break;
	      case 2:
		price=2700000;
		strcpy(model_name,"GLA Class");
		break;
	      case 3:
		price=2800000;
		strcpy(model_name,"C Class");
		break;
	      default:
		  cout<<"\n\tINVALID INPUT\n\t";
		  goto xo1;
       }
}
void main()
{
      clrscr();
      textbackground(RED);
      infor i;
      reserve r;
      int choice;
      clrscr();
      cout<<"\n\t\t\t***Patil Car Showroom***\n\n\t\tNH4 Highway Near McDonald$, Kolhapur\n\n\t\tContact: 9172604237, 8390078875\n\n\t\tEmail: patilvinu7@gmail.com, shubooo@gmail.com\n\n\t\t\tOwners:\n\t\t1. Mr. Pratik Patil\n\t\t2. Mr. Shubham Chavan\n\t\t3. Mr. Prathamesh Surve\n\t\t4. Mr. Vinayak Patil\n\n\n\n\t\t\t\tPress any key to continue!!!";
      getch();
      clrscr();
      xe:
      xz:
      clrscr();
      cout<<"\n\t\t\t\t***Menu***\n\t1. CAR INFORMATION\n\t2. RESERVATION\n\t3. RECEIPT\n\t4. EXIT\n\n\tEnter your choice\n\t";
      cin>>choice;
      switch(choice)
      {
	      case 1:
		i.info();
		break;
	      case 2:
		r.reservation();
		r.info1();
		break;
	      case 3:
		 r.payment1();
		 break;
	      case 4:
		  goto xy;
	      default:
		  cout<<"\n\tINVALID INPUT";
		  goto xz;
      }
      goto xe;
      xy:
      getch();
}