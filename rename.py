from os import listdir
from os.path import isfile, join, isdir

replace: dict[str, str] = {
        "coffee": "money",
        "milk": "crypto",
        "ascension": "graduation",
        "bean": "bitcoin"

    }

def walk_dir(path: str) -> None:
    onlyfiles: list[str] = [f for f in listdir(path) if isfile(join(path, f)) and f[0] != "." and f != "rename.py"]
    onlydir: list[str] = [f for f in listdir(path) if isdir(join(path, f)) and f[0] != "." and f != "rename.py"]
    for dir in onlydir:
        walk_dir(path + "/" + dir)
    for file in onlyfiles:
        rename_var_in(path + "/" + file)

def rename_var_in(file: str) -> None:

    f = open(file, "r");
    txt: str = f.read()
    f.close()

    open(file, "w").close()

    for inp, out in replace.items():
        for input, output in format(inp, out).items():
            txt = txt.replace(input, output)
    f = open(file, "w")
    f.write(txt)
    f.close()


def format(input: str, output: str) -> dict[str, str]:
    dic: dict[str, str] = {}

    dic[input] = output
    dic[input.title()] = str(output.title())
    
    if(output == "money"): return dic
    dic[input + "s"] = output + "s"
    dic[input.title() + "s"] = str(output.title()) + "s"
    return dic

#print(format("coffee", "money"))
walk_dir("./")

