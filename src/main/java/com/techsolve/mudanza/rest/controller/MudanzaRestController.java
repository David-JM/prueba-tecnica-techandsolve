package com.techsolve.mudanza.rest.controller;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.json.JSONObject;

import com.techsolve.mudanza.bo.MudanzaBO;
import com.techsolve.mudanza.bo.exception.BoException;
import com.techsolve.mudanza.bo.impl.BitacoraMudanzaBOImpl;
import com.techsolve.mudanza.bo.impl.MudanzaBOImpl;
import com.techsolve.mudanza.bo.impl.TripsBOImpl;
import com.techsolve.mudanza.dao.impl.BitacoraMudanzaDAOImpl;
import com.techsolve.mudanza.dao.util.EntityManagerUtil;
import com.techsolve.mudanza.model.vo.MudanzaVO;
import com.techsolve.mudanza.util.Util;

@Path("/mudanza")
public class MudanzaRestController {

	private MudanzaBO mudanzaBO;

	public MudanzaRestController() {
		mudanzaBO = new MudanzaBOImpl(new TripsBOImpl(),
				new BitacoraMudanzaBOImpl(new BitacoraMudanzaDAOImpl(EntityManagerUtil.getEntityManager())));
	}

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response create(MudanzaVO mudanzaVO) throws BoException {
		final JSONObject json = new JSONObject();
		final String ouput = Util.encodeBase64(mudanzaBO.getOutputTextFile(mudanzaVO));
		return Response.ok(json.put(Util.JSON_KEY_OUTPUT_FILE, ouput).toString()).build();
	}

}
