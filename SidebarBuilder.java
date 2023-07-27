import java.io.BufferedWriter;
import java.io.File;
import java.io.FileFilter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

class SidebarBuilder {
    public static String REG1 = "^[^_].*";
    public static String REG2 = "^[^\\.].*";
    public static String MD_REG = ".*[\\.md]$";

    public static void main(String[] args) {
        // 读取根目录 一级一级的生成 _sidebar.md 文件
        // 获取当前所在目录
        File dir;
        int level = 1;
        try {
            dir = new File("").getCanonicalFile();
            // 全部
            init(dir, dir.toString(), level);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void init(File dir, String rootPath, int level) {
        String basePath = dir.toString().replace(rootPath, "").replace("\\", "/");

        // 忽略 . _ 开头的文件
        File[] files = dir.listFiles(new FileFilter() {
            @Override
            public boolean accept(File file) {
                return file.getName().matches(REG1) && file.getName().matches(REG2);
            }
        });
        // 排序
        List<File> fileList = Arrays.asList(files);
        Collections.sort(fileList, new Comparator<File>() {

            @Override
            public int compare(File o1, File o2) {
                if (o1.isDirectory() && o2.isFile())
                    return -1;
                if (o1.isFile() && o2.isDirectory())
                    return 1;
                return o1.getName().compareTo(o2.getName());
            }
        });

        // 每层文件夹 设置一个 _sidebar.md 以及 README.md
        File sidebar = new File(dir, "_sidebar.md");        
        File remdme = new File(dir, "README.md");

        if (!sidebar.exists()) {
            try {
                sidebar.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        if (!remdme.exists()) {
            BufferedWriter bw = null;
            try {
                remdme.createNewFile();
                bw = new BufferedWriter(new OutputStreamWriter(
                        new FileOutputStream(remdme), "UTF-8"));
                bw.write("# " + dir.getName());
                bw.newLine();
                
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                if (bw != null) {
                    try {
                        bw.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }


        BufferedWriter bw = null;
        try {
            bw = new BufferedWriter(new OutputStreamWriter(
                    new FileOutputStream(sidebar), "UTF-8"));
            
            // 若文件夹超过二级 添加返回上一级
            if (level == 1) {
                bw.write("* [**书不尽意**](/README.md)");
                bw.newLine();
            } else {
                StringBuffer sb = new StringBuffer()
                    .append("* [**目录**](")
                    .append(basePath.replace(dir.getName(), ""))
                    .append("README.md)");
                bw.write(sb.toString());
                bw.newLine();
                bw.write("* [**" + dir.getName() + "简介**](" + basePath + "/README.md)");
                bw.newLine();
            }            
            
            // 遍历
            for (File file : fileList) {
                if (file.isDirectory()) {
                    init(file, rootPath, ++level);
                    // 如果是文件夹 将文件中的 README.md 设置为路由
                    StringBuffer stringBuffer = new StringBuffer()
                            .append("* [")
                            .append(file.getName())
                            .append("](")
                            .append(basePath)
                            .append("/")
                            .append(file.getName())
                            .append("/README.md)");
                    bw.write(stringBuffer.toString());
                    bw.newLine();
                } else if (file.getName().matches(MD_REG) && !file.getName().equals("README.md")) {
                    // 如果是 .md 文件 且不是 README.md 文件 配置为路由
                    StringBuffer stringBuffer = new StringBuffer()
                            .append(" * [")
                            .append(file.getName().replace(".md", ""))
                            .append("](")
                            .append(basePath)
                            .append("/")
                            .append(file.getName())
                            .append(")");
                    bw.write(stringBuffer.toString());
                    bw.newLine();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (bw != null) {
                try {
                    bw.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}