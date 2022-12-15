import java.io.*;
import java.net.*;
public class server
{
	public static void main(String args[]) throws IOException,FileNotFoundException
	{
		ServerSocket serversocket=new ServerSocket(5000);
		System.out.println("Server ready for the connection");
		Socket sock=serversocket.accept();
		System.out.println("Connection was accepted");
		InputStream istream=sock.getInputStream();
		BufferedReader bufferedreader=new BufferedReader(new InputStreamReader(istream));
		String fname=bufferedreader.readLine();
		BufferedReader contentreader=new BufferedReader(new FileReader(fname));
		OutputStream ostream=sock.getOutputStream();
		PrintWriter pwrite=new PrintWriter(ostream,true);
		String str;
		while((str=contentreader.readLine())!=null)
		{
			pwrite.println(str);
		}
		System.out.println("File content SENT successfilly");
		sock.close();
		serversocket.close();
		pwrite.close();
		bufferedreader.close();
		contentreader.close();
	}
}
