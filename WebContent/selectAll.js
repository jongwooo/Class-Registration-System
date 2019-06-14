$( document ).ready( function() {
	$( '.lecture-all' ).click( function() {
		$( '.lecture' ).prop( 'checked', this.checked );
	} );
} );

$( document ).ready( function() {
	$( '.bag-all' ).click( function() {
		$( '.bag' ).prop( 'checked', this.checked );
	} );
} );

$( document ).ready( function() {
	$( '.sincheong-all' ).click( function() {
		$( '.sincheong' ).prop( 'checked', this.checked );
	} );
} );