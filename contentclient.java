import java.io.*;
import java.net.*;
public class contentclient
{
	public static void main(String args[]) throws IOException,FileNotFoundException
	{
		Socket sock=new Socket("172.16.17.33",5000);
		System.out.println("Enter the filename:");
		BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
		String fname=reader.readLine();
		OutputStream ostream=sock.getOutputStream();
		PrintWriter pwrite=new PrintWriter(ostream,true);
		pwrite.println(fname);
		InputStream istream=sock.getInputStream();
		BufferedReader toread = new BufferedReader(new InputStreamReader(istream));
		String str;
		while((str=toread.readLine())!=null)
		{
			System.out.println(str);
		}
		pwrite.close();
		sock.close();
		toread.close();
	}
}
