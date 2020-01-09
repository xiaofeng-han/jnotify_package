package net.contentobjects.jnotify;

public class Util
{
	public static String getMaskDesc(int mask)
	{
		StringBuffer s = new StringBuffer();
		if ((mask & JNotify.FILE_CREATED) != 0)
		{
			s.append("FILE_CREATED|");
		}
		if ((mask & JNotify.FILE_DELETED) != 0)
		{
			s.append("FILE_DELETED|");
		}
		if ((mask & JNotify.FILE_MODIFIED) != 0)
		{
			s.append("FILE_MODIFIED|");
		}
		if ((mask & JNotify.FILE_RENAMED) != 0)
		{
			s.append("FILE_RENAMED|");
		}
		if (s.length() > 0)
		{
			return s.substring(0, s.length() - 1);
		}
		else
		{
			return "UNKNOWN";
		}
	}

	public static void loadNativeLibrary() throws UnsatisfiedLinkError
	{
		String arch = System.getProperty("os.arch");
		UnsatisfiedLinkError byArchitectureException = null;
		if (arch != null)
		{
			try
			{
				System.loadLibrary("jnotify-" + arch);
			}
			catch (UnsatisfiedLinkError e)
			{
				byArchitectureException = e;
			}
		}
		if (arch == null || byArchitectureException != null)
		{
			try
			{
				System.loadLibrary("jnotify");
			}
			catch (UnsatisfiedLinkError e)
			{
				StringBuilder builder = new StringBuilder();
				builder.append("Error loading JNotify native library \"jnotify\"");
				if (byArchitectureException != null)
				{
					builder.append(", also tried \"jnotify-");
					builder.append(arch);
					builder.append("\": ");
					builder.append(byArchitectureException.toString());
				}
				builder.append(", java.library.path=");
				String libraryPath = System.getProperty("java.library.path");
				if (libraryPath == null)
				{
					builder.append("(null)");
				}
				else
				{
					builder.append('"');
					builder.append(libraryPath);
					builder.append('"');
				}
				UnsatisfiedLinkError enhancedException = new UnsatisfiedLinkError(builder.toString());
				enhancedException.initCause(e);
				throw enhancedException;
			}
		}
	}
}
