# Windows注册表操作

> Windows下注册表的一些操作

## 右键添加 新建md文件

```bash
Windows Registry Editor Version 5.00

[HKEY_CLASSES_ROOT\.md]
@="typora.md"
"icon"="C:\software\Typora\Typora.exe" \\ 我的typora安装路径
[HKEY_CLASSES_ROOT\.md\OpenWithProgids]
"Typora.md"=""
"VSCode.md"=""

[HKEY_CLASSES_ROOT\.md\ShellNew]
"NullFile"=""
```

