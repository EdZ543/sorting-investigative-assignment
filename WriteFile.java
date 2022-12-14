
import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.IOException;


public class WriteFile {
    private String path;//Name and location of file
    private boolean append_to_file = false; //False means to not append, erase everything on file

    /**
     *Creates new object of WriteFile, with only the file path.
     *
     *@param file_path Name and location of file
     */
    public WriteFile(String file_path) {
        path = file_path;
    }

    /**
     * Creates new object of WriteFile, with the file path, and user can indicate if they
     * wish to append the file by setting append_value to true.
     * 
     * @param file_path Name and location of file
     * @param append_value Appends the file when true
     */
    public WriteFile( String file_path , boolean append_value ) {
        path = file_path;
        append_to_file = append_value;
    }

    public void writeToFile( String textLine ) throws IOException {
        FileWriter write = new FileWriter( path , append_to_file);//True (append to the file) or false (don't append)
        PrintWriter print_line = new PrintWriter(write);

        //Formats a string of characters and adds a newline at the end. 
        print_line.printf( "%s" + "%n" , textLine);

        //Closes the text file and frees up any resources it was using
        print_line.close();
    }
}
