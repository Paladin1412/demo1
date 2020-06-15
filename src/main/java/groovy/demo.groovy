def param1 = p1
def param2 = p2
StringBuilder builder = new StringBuilder()
for (int i = 0; i <param1; i++) {
    builder.append(param2+",")
}
return builder.toString()
