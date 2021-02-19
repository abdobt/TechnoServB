package ma.fstt.controller;

import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.nio.file.Paths;

public class test {

	public static void main(String[] args) {
		String cwd = Paths.get("").toString();
//		this.getClass().getClassLoader().getResource("").getPath()
		Path path = FileSystems.getDefault().getPath("").toAbsolutePath();
		System.out.print(path);

	}

}
