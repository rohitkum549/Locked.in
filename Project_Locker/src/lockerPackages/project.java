package lockerPackages;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class project 
{
	public static void main(String args[]) throws IOException
	{
		project pro=new project();
		Scanner X=new Scanner(System.in);
		System.out.println("\tEnter the DirPath");
		String DirPath=X.nextLine();
		File folder=new File(DirPath);
		//		folder.mkdirs();
		while(true)
		{
			System.out.println("\t* * * * * * * * Welcome Here * * * * * * * *");
			//			System.out.println("\t* * * * * * * * * * * * * * * * * * * * * * *");
			System.out.println("\t* * * * * * * * Locker.in * * * * * * * *  * ");
			//			System.out.println("\t* * * * * * * * * * * * * * * * * * * * * * *");
			System.out.println("\tApplication Developer: Rohit Kumar Jha");
			//			System.out.println("\t* * * * * * * * * * * * * * * * * * * * * * *");
			System.out.println("\tFile menu Related menu Application");
			//			System.out.println("\t* * * * * * * * * * * * * * * * * * * * * * *");
			System.out.println();
			System.out.println("\t|^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^|");
			System.out.println("\t|            MAIN MENU              |");
			System.out.println("\t|^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^|");
			System.out.println("\t| Select any one of the following:  |");
			System.out.println("\t|   1 -> List files in directory    |");
			System.out.println("\t|   2 -> Add, Delete or Search      |");
			System.out.println("\t|   3 -> Exit Program               |");
			System.out.println("\t|^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^|");
			System.out.print("Enter Your Choice:--- ");
			try
			{
				int choise=X.nextInt();
				switch(choise)
				{
				/*
				 *  1 -> List files in directory  
				 */
				case 1:
					File[] FileList=folder.listFiles();
					Arrays.sort(FileList);
					for(int i=0;i<FileList.length;i++)
					{
						System.out.println("File are:-"+FileList[i].getName());
					}
					break;
					/*
					 * 2 -> Add, Delete or Search 
					 */
				case 2:
					boolean b=true;
					while(b)
					{
						System.out.println("\t\n1.Add \t\n2.Delete \t\n3.Search \t\n4. Back to Main Menu \t\n5.Terminate the Program");
						System.out.print("Enter The Choice:--- ");
						try
						{
						int choice2=X.nextInt();
						switch(choice2)
						{
						case 1:					/*ADD*/
							System.out.println("Enter The File Name:-");
							String FileNameAdd=X.next();
							System.out.println();
							if(new File(folder,FileNameAdd).exists())
							{
								System.out.println("Already Exits Please Try Different Name---"+FileNameAdd);
							}
							else
							{
								File AddFile=new File(DirPath+"/"+FileNameAdd);
								//							AddFile.mkdir();
								if (AddFile.createNewFile())
								{
									System.out.println("File Added:-  "+FileNameAdd+" "+AddFile);
								}
							}
							break;
						case 2:			/*DELETE*/
							System.out.println("Enter the FileName To Delete:--");
							String DeleteFileName=X.next();
							File DeleteFile=new File(DirPath+"/"+DeleteFileName);
							//						boolean delete=folder3.delete();
							if(DeleteFile.delete())
							{
								System.out.println(DeleteFileName+" !!-Deleted Sucessfully!!");
							}
							else
							{
								System.out.println("!!!-File not Found!!!");
							}
							break;
						case 3:			/*SEARCH*/



							System.out.println("Enter The File Name:-");
							String FileName=X.next();
							File SearchFileDir[]=folder.listFiles();
							boolean found=false;
							for(int i=0;i<SearchFileDir.length;i++)
							{
								if(SearchFileDir[i].getName().startsWith(FileName))
								{
									found=true;
									break;
								}
							}
							if(found)
							{
								System.out.println("FileName"+FileName+" * * *--Found--* * *");
							}
							else
							{
								System.out.println("FileName---"+FileName+" !!!File Does not exits!!!");
							}
							break;
						case 4:
							b=false;
							break;
						case 5:
							System.out.println("!!! Thank You !!! \n!!HAPPY LEARNING!!");
							System.exit(choice2);

						default:
							System.out.println("You press Wrong KeyWord");
						}
					}
						catch (Exception e)
						{
							System.out.println("Invalid Input");
							pro.main(args);
						}
					}
					break;
				case 3:
					System.out.println("Thanks For Vist \n!!HAPPY LEARNING!! ");
					System.exit(0);
				default:
					System.out.println("You press Wrong Keyword");
					break;
				}
			}
			catch (Exception e)
			{
				System.out.println("Invalid Input");
				pro.main(args);

			}
		}
	}
}