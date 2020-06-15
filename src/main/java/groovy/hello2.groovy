import groovy.Ctx


def helloWithParam(Ctx ctx){
    def param1 = ctx.p1
    def param2 = ctx.p2
    StringBuilder builder = new StringBuilder()
    for (int i = 0; i <param1; i++) {
        builder.append(param2+",")
    }
    return builder.toString()
}


