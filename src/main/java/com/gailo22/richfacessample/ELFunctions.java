package com.gailo22.richfacessample;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

public class ELFunctions {
	private static final Logger LOGGER = Logger.getLogger(ELFunctions.class.getName());

	public static void showSource(final FacesContext ctx, final String file) {
		final ExternalContext extCtx = ctx.getExternalContext();
		final BufferedReader r = new BufferedReader(new InputStreamReader(extCtx
				.getResourceAsStream(file)));
		final StringWriter w = new StringWriter();
		final PrintWriter pw = new PrintWriter(w);

		try {
			for (String s = r.readLine(); s != null; s = r.readLine()) {
				pw.write(s);
				pw.write('\n');
			}
			ctx.getResponseWriter().writeText(w.toString(), null);
		} catch (final IOException ioe) {
			if (LOGGER.isLoggable(Level.SEVERE)) {
				LOGGER.log(Level.SEVERE, ioe.toString(), ioe);
			}
		}
	}
}