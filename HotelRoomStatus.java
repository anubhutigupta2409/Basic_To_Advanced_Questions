//program to display the total number of rooms, number of vacant rooms and filled rooms,
//where the number of rooms per floor is variable

import java.util.*;

public class HotelRoomStatus
{
	public static void main(String args[])
	{
		Scanner sc= new Scanner(System.in);
		int hotel[][]=new int[10][];
		for(int i=0;i<10;i++)
		{
			System.out.println("Enter the number of rooms for floor number-"+(i+1));
			int roomsPerFloor=sc.nextInt();
			int roomStatus[]=new int[roomsPerFloor];

			for(int j=0;j<roomsPerFloor;j++)
			{
				System.out.println("Enter the status for room number-"+(j+1)+" of floor number-"+(i+1));
				roomStatus[j]=sc.nextInt();
			}

			hotel[i]=roomStatus;
		}

		int count0=0,count1=0,rooms=0;
		for(int i=0;i<10;i++)
		{
			rooms+=hotel[i].length;
			for(int j=0;j<hotel[i].length;j++)
			{
				if(hotel[i][j]==0)
					count0++;
				else if(hotel[i][j]==1)
					count1++;
			}
		}
		System.out.println("Total Number of Rooms:"+rooms+"\nNumber of occupied rooms:"+count1+"\nNumber of vacant rooms:"+count0);
	}

}