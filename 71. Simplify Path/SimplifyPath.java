class SimplifyPath {
    public String simplifyPath(String path) {
        if(path.length() == 1) {
            return path;
        }

        Deque<String> stack = new ArrayDeque<>();
        for(String s : path.split("/")) {
            if("".equals(s) || ".".equals(s)) {
                continue;
            }

            if("..".equals(s)) {
                if(!stack.isEmpty()) {
                    stack.pop();
                }
            } else {
                stack.push(s);
            }
        }

        StringBuilder sb = new StringBuilder();
        if(stack.isEmpty()) {
            sb.append("/");
        } else {
            while(!stack.isEmpty()) {
                sb.append("/");
                sb.append(stack.removeLast());
            }
        }
        return sb.toString();
    }
}
