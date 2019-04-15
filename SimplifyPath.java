/*
Given an absolute path for a file (Unix-style), simplify it. Or in other words, convert it to the canonical path.

In a UNIX-style file system, a period . refers to the current directory. Furthermore, a double period .. moves the directory up a level. For more information, see: Absolute path vs relative path in Linux/Unix

Note that the returned canonical path must always begin with a slash /, and there must be only a single slash / between two directory names. The last directory name (if it exists) must not end with a trailing /. Also, the canonical path must be the shortest string representing the absolute path.

*/

class Solution {

	public String simplifyPath(String path) {

		return buildPathFromList(simplifyPath(strPathToArray(path)));
	}

	public String buildPathFromList(List<String> pathList) {
		if (pathList.size() == 0) {
			return "/";
		}

		StringBuilder strPath = new StringBuilder();

		for (int i = 0; i < pathList.size(); i++) {
			strPath.append("/");

			strPath.append(pathList.get(i));
		}

		return strPath.toString();
	}

	public String[] strPathToArray(String path) {

		return path.split("/");

	}

	public List<String> simplifyPath(String[] pathArray) {
		List<String> pathArrayActual = new ArrayList<String>();

		for (int i = 0; i < pathArray.length; i++) {

			if (pathArray[i].trim().isEmpty() || pathArray[i].equals("."))
				continue;

			if (pathArray[i].equals("..")) {
				if (pathArrayActual.size() > 0) {
					pathArrayActual.remove(pathArrayActual.size() - 1);
				}
				continue;

			}

			pathArrayActual.add(pathArray[i]);

		}
		return pathArrayActual;
	}

}
