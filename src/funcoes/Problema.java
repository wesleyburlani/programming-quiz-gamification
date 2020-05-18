package funcoes;

public class Problema {
	public String transformString(String n){
		switch(n){
		case "1000":
			return "O que esse programa imprime ?\n\n#include <stdio.h>\nint main(){\n   printf(\"Hello World\\n\");\n   return 0;\n}";
		case "1001":
			return "O que esse programa imprime #include <stdio.h>\n\nint main(){\n   int i;\n   for(i = 0; i <= 5; i++){\n      printf(\"%d%c\", i, i != 5 ? ' ' : '\\n');\n   }\n   for(i = 5; i >= 0; i--){\n      printf(\"%d%c\", i, i != 0 ? ' ' : '\\n');\n   }\n   return 0;\n}";
		case "1002":
			return "public class questaoA{\n    public static void main(String args[]){\n        String stringA = \"string\";\n        String stringB = \"string\";\n\n        if(stringA == stringB){\n            System.out.println(\"São iguais\");\n        }\n        else{\n            System.out.println(\"São diferentes\");\n         }\n         \n   }   \n}";
		case "1003":
			return "#include <stdio.h>\n\n   int main(){\n      int a, *aa;\n      float b, *bb;\n      char c,    *cc;\n      a = 1; b = 2.0;    c = 'c';\n      printf(\"%d %.1f %c - \", a, b, c);\n      aa = &a;bb = &b;cc = &c;\n      *aa = 123; *bb = 12.3 ;    *cc = 'A';\n      printf(\"%d %.1f %c\", a, b, c);\n      return 0;\n}";
		default:
			return null;
		}
	}
}